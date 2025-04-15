package com.example.roguetraining.models

data class TrainingEnvironment(
    val name: String,
    val description: String,
    val gymType: GymType,
    val typicalTools: List<String>
) 