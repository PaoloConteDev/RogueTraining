package com.example.roguetraining.database

import com.example.roguetraining.models.TrainingEnvironment
import com.example.roguetraining.models.GymType

object TrainingEnvironmentDatabase {
    val environments = listOf(
        TrainingEnvironment(
            name = "Large Gym",
            description = "Full-service facility with extensive equipment and specialized machines",
            gymType = GymType.LARGE,
            typicalTools = listOf(
                "Dumbbells",
                "Barbell",
                "Kettlebell",
                "Weight Plates",
                "Cable Machine",
                "Leg Press Machine",
                "Lat Pulldown Machine",
                "Chest Press Machine",
                "Pull-up Bar",
                "Parallel Bars",
                "Gymnastic Rings",
                "Treadmill",
                "Stationary Bike",
                "Rowing Machine",
                "Resistance Bands",
                "Medicine Ball",
                "Yoga Mat",
                "Jump Rope"
            )
        ),
        TrainingEnvironment(
            name = "Medium Gym",
            description = "Well-equipped facility with a variety of machines and free weights",
            gymType = GymType.MEDIUM,
            typicalTools = listOf(
                "Dumbbells",
                "Barbell",
                "Kettlebell",
                "Weight Plates",
                "Cable Machine",
                "Leg Press Machine",
                "Lat Pulldown Machine",
                "Chest Press Machine",
                "Pull-up Bar",
                "Parallel Bars",
                "Gymnastic Rings",
                "Treadmill",
                "Stationary Bike",
                "Rowing Machine",
                "Resistance Bands",
                "Medicine Ball",
                "Yoga Mat"
            )
        ),
        TrainingEnvironment(
            name = "Small Gym",
            description = "Basic equipment with limited machines, good for general fitness",
            gymType = GymType.SMALL,
            typicalTools = listOf(
                "Dumbbells",
                "Kettlebell",
                "Pull-up Bar",
                "Parallel Bars",
                "Stationary Bike",
                "Resistance Bands",
                "Medicine Ball",
                "Yoga Mat"
            )
        ),
        TrainingEnvironment(
            name = "Home Gym",
            description = "Limited space and equipment, focusing on bodyweight and basic equipment",
            gymType = GymType.HOME,
            typicalTools = listOf(
                "Dumbbells",
                "Kettlebell",
                "Pull-up Bar",
                "Resistance Bands",
                "Yoga Mat",
                "Jump Rope"
            )
        ),
        TrainingEnvironment(
            name = "Free Body Only",
            description = "No tools",
            gymType = GymType.BODY,
            typicalTools = listOf(

            )
        ),
    )
} 