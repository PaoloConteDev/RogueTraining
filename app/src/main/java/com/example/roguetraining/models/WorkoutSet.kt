package com.example.roguetraining.models

import com.example.roguetraining.models.Exercise

data class WorkoutSet(
    val exercise: Exercise,
    val sets: Int,
    val reps: Int,
    val restTime: Int,
    private val completedSets: MutableList<Boolean> = MutableList(sets) { false }
) {
    fun markSetComplete(setIndex: Int) {
        if (setIndex in completedSets.indices) {
            completedSets[setIndex] = true
        }
    }

    fun isSetComplete(setIndex: Int): Boolean {
        return setIndex in completedSets.indices && completedSets[setIndex]
    }

    fun isWorkoutComplete(): Boolean {
        return completedSets.all { it }
    }

    fun getCompletedSetsCount(): Int {
        return completedSets.count { it }
    }
} 