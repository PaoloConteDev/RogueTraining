package com.example.roguetraining

import kotlin.random.Random
import com.example.roguetraining.database.ExerciseDatabase
import com.example.roguetraining.models.Difficulty
import com.example.roguetraining.models.Exercise

class WorkoutGenerator {
    data class WorkoutPreferences(
        val difficulty: Difficulty,
        val targetMuscleGroups: List<String>,
        val availableTools: List<String>,
        val workoutDuration: Int // in minutes
    )

    fun generateWorkout(preferences: WorkoutPreferences): List<Exercise> {
        // Se non ci sono strumenti selezionati, filtra solo gli esercizi a corpo libero
        val filteredExercises = if (preferences.availableTools.isEmpty()) {
            ExerciseDatabase.allExercises.filter { exercise ->
                exercise.difficulty == preferences.difficulty &&
                exercise.primaryMuscleGroup in preferences.targetMuscleGroups &&
                exercise.requiredTools.isEmpty()
            }
        } else {
            ExerciseDatabase.allExercises.filter { exercise ->
                exercise.difficulty == preferences.difficulty &&
                exercise.primaryMuscleGroup in preferences.targetMuscleGroups &&
                (exercise.requiredTools.isEmpty() || exercise.requiredTools.all { it in preferences.availableTools })
            }
        }

        if (filteredExercises.isEmpty()) {
            return emptyList()
        }

        // Calculate number of exercises based on workout duration
        // Assuming 3 minutes per exercise (including rest)
        val numberOfExercises = (preferences.workoutDuration / 3).coerceAtMost(filteredExercises.size)
        
        // Ensure we have at least 3 exercises
        val finalNumberOfExercises = numberOfExercises.coerceAtLeast(3)

        // Randomly select exercises
        return filteredExercises.shuffled().take(finalNumberOfExercises)
    }

    companion object {
        // Helper function to get a random exercise for a specific muscle group
        fun getRandomExerciseForMuscleGroup(
            muscleGroup: String,
            difficulty: Difficulty,
            availableTools: List<String>
        ): Exercise? {
            return ExerciseDatabase.allExercises
                .filter { 
                    it.primaryMuscleGroup == muscleGroup && 
                    it.difficulty == difficulty &&
                    (it.requiredTools.isEmpty() || it.requiredTools.all { tool -> tool in availableTools })
                }
                .randomOrNull()
        }
    }
} 