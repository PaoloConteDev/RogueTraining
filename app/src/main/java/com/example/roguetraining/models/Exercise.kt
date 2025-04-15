package com.example.roguetraining.models

data class Exercise(
    val name: String,
    val primaryMuscleGroup: String,
    val secondaryMuscleGroups: List<String>,
    val requiredTools: List<String>,
    val description: String,
    val difficulty: Difficulty,
    val videoResource: String = "" // Default to empty string if no video available
) 