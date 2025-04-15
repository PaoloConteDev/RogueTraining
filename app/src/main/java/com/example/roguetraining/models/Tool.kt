package com.example.roguetraining.models

data class Tool(
    val name: String,
    val description: String,
    val gymTypes: List<GymType>,
    val category: String
) 