package com.example.roguetraining

import com.example.roguetraining.database.ExerciseDatabase
import com.example.roguetraining.models.Difficulty
import com.example.roguetraining.models.Exercise
import com.example.roguetraining.models.TrainingIntensity
import kotlin.math.roundToInt
import kotlin.random.Random

class ImprovedWorkoutGenerator {
    data class WorkoutPreferences(
        val difficulty: Difficulty,
        val targetMuscleGroups: List<String>,
        val availableTools: List<String>,
        val workoutDuration: Int, // in minutes
        val sex: String,
        val bodyWeight: Float,
        val height: Float,
        val age: Int,
        val intensity: TrainingIntensity
    )

    data class WorkoutSet(
        val exercise: Exercise,
        val sets: Int,
        val reps: Int,
        val suggestedWeightKg: IntRange
    )

    fun generateWorkout(preferences: WorkoutPreferences): List<WorkoutSet> {
        val filteredExercises = ExerciseDatabase.allExercises.filter { exercise ->
            val difficultyMatch = exercise.difficulty == preferences.difficulty || isNearDifficulty(preferences.difficulty, exercise.difficulty)
            val toolMatch = exercise.requiredTools.isEmpty() || exercise.requiredTools.all { it in preferences.availableTools }
            val muscleMatch = preferences.targetMuscleGroups.any { it in listOf(exercise.primaryMuscleGroup) + exercise.secondaryMuscleGroups }
            difficultyMatch && toolMatch && muscleMatch
        }

        if (filteredExercises.isEmpty()) return emptyList()

        val numberOfExercises = (preferences.workoutDuration / 3).coerceAtMost(filteredExercises.size).coerceAtLeast(3)

        return filteredExercises.shuffled().take(numberOfExercises).map { exercise ->
            val (sets, reps) = getRepsAndSets(preferences.difficulty, preferences.intensity)
            val weightRange = WeightCalculator.getWeightRange(
                preferences.sex,
                preferences.bodyWeight,
                preferences.height,
                preferences.age,
                preferences.intensity,
                exercise.primaryMuscleGroup,
                exercise.name
            )
            WorkoutSet(
                exercise = exercise,
                sets = sets,
                reps = reps,
                suggestedWeightKg = weightRange.first..weightRange.second
            )
        }
    }

    private fun isNearDifficulty(target: Difficulty, actual: Difficulty): Boolean {
        return when (target) {
            Difficulty.BEGINNER -> actual == Difficulty.INTERMEDIATE
            Difficulty.INTERMEDIATE -> actual == Difficulty.BEGINNER || actual == Difficulty.ADVANCED
            Difficulty.ADVANCED -> actual == Difficulty.INTERMEDIATE
        }
    }

    private fun getRepsAndSets(difficulty: Difficulty, intensity: TrainingIntensity): Pair<Int, Int> {
        return when (difficulty) {
            Difficulty.BEGINNER -> when (intensity) {
                TrainingIntensity.LOW -> 3 to 10
                TrainingIntensity.MEDIUM -> 3 to 12
                TrainingIntensity.HIGH -> 4 to 12
            }
            Difficulty.INTERMEDIATE -> when (intensity) {
                TrainingIntensity.LOW -> 3 to 10
                TrainingIntensity.MEDIUM -> 4 to 10
                TrainingIntensity.HIGH -> 4 to 12
            }
            Difficulty.ADVANCED -> when (intensity) {
                TrainingIntensity.LOW -> 4 to 8
                TrainingIntensity.MEDIUM -> 4 to 10
                TrainingIntensity.HIGH -> 5 to 10
            }
        }
    }
}
