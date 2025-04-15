package com.example.roguetraining

import com.example.roguetraining.models.Exercise

data class WorkoutSet(
    val exercise: Exercise,
    val targetSets: Int,
    val targetReps: Int,
    val restTimeSeconds: Int,
    val completedSets: MutableList<Boolean> = mutableListOf()
) {
    init {
        // Initialize completed sets list with false values
        repeat(targetSets) {
            completedSets.add(false)
        }
    }

    fun markSetComplete(setIndex: Int) {
        if (setIndex in completedSets.indices) {
            completedSets[setIndex] = true
        }
    }

    fun isWorkoutComplete(): Boolean {
        return completedSets.all { it }
    }
} 