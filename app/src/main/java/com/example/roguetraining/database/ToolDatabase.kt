package com.example.roguetraining.database

import com.example.roguetraining.models.Tool
import com.example.roguetraining.models.GymType

object ToolDatabase {
    val allTools = listOf(
        // Free Weights
        Tool(
            name = "Dumbbells",
            description = "Handheld weights for various exercises",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Free Weights"
        ),
        Tool(
            name = "Barbell",
            description = "Long bar for weightlifting exercises",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Free Weights"
        ),
        Tool(
            name = "Kettlebell",
            description = "Cast iron weight with a handle for dynamic exercises",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Free Weights"
        ),
        Tool(
            name = "Weight Plates",
            description = "Circular weights for barbells and machines",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Free Weights"
        ),

        // Machines
        Tool(
            name = "Cable Machine",
            description = "Versatile machine with adjustable pulleys and cables",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Machines"
        ),
        Tool(
            name = "Leg Press Machine",
            description = "Machine for leg exercises with adjustable weight",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Machines"
        ),
        Tool(
            name = "Lat Pulldown Machine",
            description = "Machine for back exercises with adjustable weight",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Machines"
        ),
        Tool(
            name = "Chest Press Machine",
            description = "Machine for chest exercises with adjustable weight",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Machines"
        ),

        // Bodyweight Equipment
        Tool(
            name = "Pull-up Bar",
            description = "Bar mounted for bodyweight exercises",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Bodyweight"
        ),
        Tool(
            name = "Parallel Bars",
            description = "Bars for dips and other bodyweight exercises",
            gymTypes = listOf(GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Bodyweight"
        ),
        Tool(
            name = "Gymnastic Rings",
            description = "Rings for advanced bodyweight exercises",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Bodyweight"
        ),

        // Cardio Equipment
        Tool(
            name = "Treadmill",
            description = "Machine for running and walking exercises",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Cardio"
        ),
        Tool(
            name = "Stationary Bike",
            description = "Bike for cycling exercises",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Cardio"
        ),
        Tool(
            name = "Rowing Machine",
            description = "Machine for full-body cardio workout",
            gymTypes = listOf(GymType.MEDIUM, GymType.LARGE),
            category = "Cardio"
        ),

        // Accessories
        Tool(
            name = "Resistance Bands",
            description = "Elastic bands for resistance training",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Accessories"
        ),
        Tool(
            name = "Medicine Ball",
            description = "Weighted ball for various exercises",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Accessories"
        ),
        Tool(
            name = "Yoga Mat",
            description = "Mat for floor exercises and stretching",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Accessories"
        ),
        Tool(
            name = "Jump Rope",
            description = "Rope for cardio and coordination exercises",
            gymTypes = listOf(GymType.HOME, GymType.SMALL, GymType.MEDIUM, GymType.LARGE),
            category = "Accessories"
        )
    )

    fun getToolsByGymType(gymType: GymType): List<Tool> {
        return allTools.filter { it.gymTypes.contains(gymType) }
    }
} 