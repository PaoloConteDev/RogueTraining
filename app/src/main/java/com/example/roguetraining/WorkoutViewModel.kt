package com.example.roguetraining

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.roguetraining.database.ExerciseDatabase
import com.example.roguetraining.models.TrainingIntensity
import com.example.roguetraining.models.TrainingEnvironment
import com.example.roguetraining.models.Difficulty
import com.example.roguetraining.models.Exercise
import com.example.roguetraining.models.WorkoutSet
import com.example.roguetraining.data.UserInfo
import com.example.roguetraining.data.UserPreferences
import kotlinx.coroutines.launch

// Extension function to convert duration to minutes
private fun Int.toMinutes(): Int {
    return this * 60 // Assuming duration is in hours, convert to minutes
}

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val userPreferences = UserPreferences(application)

    private val _sex = MutableStateFlow("")
    val sex: StateFlow<String> = _sex.asStateFlow()

    private val _weight = MutableStateFlow(0)
    val weight: StateFlow<Int> = _weight.asStateFlow()

    private val _height = MutableStateFlow(0)
    val height: StateFlow<Int> = _height.asStateFlow()

    private val _age = MutableStateFlow(0)
    val age: StateFlow<Int> = _age.asStateFlow()

    private val _frequency = MutableStateFlow(0)
    val frequency: StateFlow<Int> = _frequency.asStateFlow()

    private val _duration = MutableStateFlow(0)
    val duration: StateFlow<Int> = _duration.asStateFlow()

    private val _intensity = MutableStateFlow<TrainingIntensity?>(null)
    val intensity: StateFlow<TrainingIntensity?> = _intensity.asStateFlow()

    private val _tools = MutableStateFlow<List<String>>(emptyList())
    val tools: StateFlow<List<String>> = _tools.asStateFlow()

    private val _muscleGroups = MutableStateFlow<List<String>>(emptyList())
    val muscleGroups: StateFlow<List<String>> = _muscleGroups.asStateFlow()

    private val _exercises = MutableStateFlow<List<Exercise>>(ExerciseDatabase.allExercises)
    val exercises: StateFlow<List<Exercise>> = _exercises.asStateFlow()

    private val _trainingType = MutableStateFlow("")
    val trainingType: StateFlow<String> = _trainingType.asStateFlow()

    private val _environment = MutableStateFlow<TrainingEnvironment?>(null)
    val environment: StateFlow<TrainingEnvironment?> = _environment.asStateFlow()

    private val _currentWorkout = MutableStateFlow<List<WorkoutSet>>(emptyList())
    val currentWorkout: StateFlow<List<WorkoutSet>> = _currentWorkout.asStateFlow()

    init {
        // Load saved user data
        viewModelScope.launch {
            try {
                userPreferences.userInfo.collect { userInfo ->
                    _sex.value = userInfo.sex
                    _weight.value = userInfo.weight
                    _height.value = userInfo.height
                    _age.value = userInfo.age
                }
            } catch (e: Exception) {
                Log.e("WorkoutViewModel", "Error loading user data: ${e.message}")
            }
        }
    }

    fun setSex(value: String) {
        _sex.value = value
        saveUserInfo()
    }

    fun setWeight(value: Int) {
        _weight.value = value
        saveUserInfo()
    }

    fun setHeight(value: Int) {
        _height.value = value
        saveUserInfo()
    }

    fun setAge(value: Int) {
        _age.value = value
        saveUserInfo()
    }

    fun setTrainingType(type: String) {
        _trainingType.value = type
    }

    fun setFrequency(frequency: Int) {
        _frequency.value = frequency
    }

    fun setDuration(duration: Int) {
        // Convert selection to actual minutes
        val actualMinutes = when (duration) {
            1 -> 30  // 30 minutes
            2 -> 60  // 1 hour
            3 -> 90  // 1 hour and 30 minutes
            else -> 60 // Default to 1 hour
        }
        _duration.value = actualMinutes
    }

    fun setIntensity(intensity: TrainingIntensity) {
        _intensity.value = intensity
    }

    fun setTools(tools: List<String>) {
        _tools.value = tools
    }

    fun setMuscleGroups(muscleGroups: List<String>) {
        _muscleGroups.value = muscleGroups
    }

    fun setEnvironment(environment: TrainingEnvironment) {
        _environment.value = environment
        // Pre-select tools based on environment
        _tools.value = environment.typicalTools
    }

    fun getFilteredExercises(): List<Exercise> {
        val selectedTools = _tools.value
        val selectedMuscleGroups = _muscleGroups.value

        return _exercises.value.filter { exercise ->
            // Filtra per gruppo muscolare
            (selectedMuscleGroups.isEmpty() || selectedMuscleGroups.contains(exercise.primaryMuscleGroup)) &&
                    // Filtra per strumenti disponibili (se l'esercizio richiede attrezzi)
                    (exercise.requiredTools.isEmpty() || selectedTools.containsAll(exercise.requiredTools))
        }
    }

    fun generateWorkout() {
        try {
            Log.d("WorkoutViewModel", "Starting workout generation")
            Log.d("WorkoutViewModel", "User data - Sex: ${sex.value}, Weight: ${weight.value}, Height: ${height.value}, Age: ${age.value}")
            
            val exercises = getFilteredExercises()
            Log.d("WorkoutViewModel", "Filtered exercises count: ${exercises.size}")
            
            val workoutDuration = duration.value
            val currentIntensity = intensity.value ?: TrainingIntensity.MEDIUM

            // Determine number of exercises based on duration and intensity
            val targetExerciseCount = when (workoutDuration) {
                30 -> when (currentIntensity) {
                    TrainingIntensity.LOW -> 4  // More exercises with fewer sets
                    TrainingIntensity.MEDIUM -> 3  // Balanced approach
                    TrainingIntensity.HIGH -> 2   // Fewer exercises with more sets
                }
                60 -> when (currentIntensity) {
                    TrainingIntensity.LOW -> 8
                    TrainingIntensity.MEDIUM -> 6
                    TrainingIntensity.HIGH -> 4
                }
                90 -> when (currentIntensity) {
                    TrainingIntensity.LOW -> 12
                    TrainingIntensity.MEDIUM -> 8
                    TrainingIntensity.HIGH -> 6
                }
                else -> 6 // Default to medium
            }

            val workoutSets = mutableListOf<WorkoutSet>()
            var remainingTime = workoutDuration * 60 // Convert to seconds

            // Calculate base rest time based on intensity
            val baseRestTime = when (intensity.value) {
                TrainingIntensity.LOW -> 90
                TrainingIntensity.MEDIUM -> 60
                TrainingIntensity.HIGH -> 45
                null -> 60
            }

            // Select exercises up to the target count
            val selectedExercises = exercises.shuffled().take(targetExerciseCount)
            Log.d("WorkoutViewModel", "Selected exercises count: ${selectedExercises.size}")

            // Distribute exercises across available time
            for (exercise in selectedExercises) {
                try {
                    // Calculate sets and reps based on intensity and difficulty
                    val (sets, reps) = when (currentIntensity) {
                        TrainingIntensity.LOW -> when (exercise.difficulty) {
                            Difficulty.BEGINNER -> 2 to 12..15  // 2 sets for beginners
                            Difficulty.INTERMEDIATE -> 3 to 12..15  // 3 sets for intermediates
                            Difficulty.ADVANCED -> 3 to 12..15  // 3 sets for advanced
                        }
                        TrainingIntensity.MEDIUM -> when (exercise.difficulty) {
                            Difficulty.BEGINNER -> 3 to 8..12  // 3 sets for beginners
                            Difficulty.INTERMEDIATE -> 4 to 8..12  // 4 sets for intermediates
                            Difficulty.ADVANCED -> 4 to 8..12  // 4 sets for advanced
                        }
                        TrainingIntensity.HIGH -> when (exercise.difficulty) {
                            Difficulty.BEGINNER -> 4 to 4..6  // 4 sets for beginners
                            Difficulty.INTERMEDIATE -> 5 to 4..6  // 5 sets for intermediates
                            Difficulty.ADVANCED -> 5 to 4..6  // 5 sets for advanced
                        }
                    }

                    // Calculate time needed for this exercise
                    val exerciseTime = (sets * (reps.last * 3 + baseRestTime)) // 3 seconds per rep + rest time
                    if (exerciseTime > remainingTime) break

                    // Calculate recommended weight for all exercises
                    val recommendedWeight = try {
                        if (exercise.supportsWeights) {
                            val (minWeight, maxWeight) = WeightCalculator.getWeightRange(
                                sex = sex.value,
                                bodyWeight = weight.value.toFloat(),
                                height = height.value.toFloat(),
                                age = age.value,
                                intensity = currentIntensity,
                                muscleGroup = exercise.primaryMuscleGroup,
                                exerciseName = exercise.name
                            )
                            Log.d("WorkoutViewModel", "Calculated weight for ${exercise.name}: $minWeight-$maxWeight kg")
                            "$minWeight-$maxWeight kg"
                        } else {
                            null
                        }
                    } catch (e: Exception) {
                        Log.e("WorkoutViewModel", "Error calculating weight for exercise ${exercise.name}: ${e.message}")
                        null
                    }

                    workoutSets.add(WorkoutSet(
                        exercise = exercise,
                        sets = sets,
                        reps = reps.first,  // Use the lower bound of the rep range
                        restTime = baseRestTime,
                        recommendedWeight = recommendedWeight
                    ))
                    remainingTime -= exerciseTime
                    
                    Log.d("WorkoutViewModel", "Added exercise: ${exercise.name} with sets: $sets, reps: ${reps.first}")
                } catch (e: Exception) {
                    Log.e("WorkoutViewModel", "Error processing exercise ${exercise.name}: ${e.message}")
                }
            }

            Log.d("WorkoutViewModel", "Workout generation completed with ${workoutSets.size} exercises")
            _currentWorkout.value = workoutSets
        } catch (e: Exception) {
            Log.e("WorkoutViewModel", "Error generating workout: ${e.message}")
            e.printStackTrace()
            _currentWorkout.value = emptyList()
        }
    }

    fun markSetComplete(exerciseIndex: Int, setIndex: Int) {
        val updatedWorkout = _currentWorkout.value.toMutableList()
        if (exerciseIndex in updatedWorkout.indices) {
            updatedWorkout[exerciseIndex].markSetComplete(setIndex)
            _currentWorkout.value = updatedWorkout
        }
    }

    fun isWorkoutComplete(): Boolean {
        return _currentWorkout.value.all { it.isWorkoutComplete() }
    }

    private fun saveUserInfo() {
        viewModelScope.launch {
            try {
                userPreferences.saveUserInfo(
                    UserInfo(
                        sex = _sex.value,
                        weight = _weight.value,
                        height = _height.value,
                        age = _age.value
                    )
                )
            } catch (e: Exception) {
                Log.e("WorkoutViewModel", "Error saving user data: ${e.message}")
            }
        }
    }
}