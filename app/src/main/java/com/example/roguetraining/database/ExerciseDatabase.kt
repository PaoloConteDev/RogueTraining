package com.example.roguetraining.database

import com.example.roguetraining.models.Exercise
import com.example.roguetraining.models.Difficulty

object ExerciseDatabase {
    val allExercises = listOf(
        // Petto
        Exercise(
            name = "Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posizionati in plank con le mani alla larghezza delle spalle. Abbassa il corpo mantenendo i gomiti vicini al corpo, poi spingi verso l'alto.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "pushup"
        ),
        Exercise(
            name = "Diamond Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani a forma di diamante sotto il petto. Esegui i push-up mantenendo i gomiti vicini al corpo.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "diamond_pushup"
        ),
        Exercise(
            name = "Wide Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani più larghe delle spalle. Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "wide_pushup"
        ),
        Exercise(
            name = "Incline Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona le mani su una superficie rialzata (panca o gradino). Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "incline_pushup"
        ),
        Exercise(
            name = "Decline Push-ups",
            primaryMuscleGroup = "Chest",
            secondaryMuscleGroups = listOf("Triceps", "Shoulders"),
            requiredTools = emptyList(),
            description = "Posiziona i piedi su una superficie rialzata. Esegui i push-up mantenendo il corpo in linea retta.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "decline_pushup"
        ),

        // Schiena
        Exercise(
            name = "Superman",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Glutes", "Lower back"),
            requiredTools = emptyList(),
            description = "Sdraiati a pancia in giù con le braccia tese in avanti. Solleva contemporaneamente braccia e gambe dal pavimento.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "superman"
        ),
        Exercise(
            name = "Bird Dog",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Core", "Glutes"),
            requiredTools = emptyList(),
            description = "In posizione quadrupedica, estendi contemporaneamente un braccio e la gamba opposta. Mantieni la posizione per 2 secondi.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "bird_dog"
        ),
        Exercise(
            name = "Back Extension",
            primaryMuscleGroup = "Back",
            secondaryMuscleGroups = listOf("Glutes", "Lower back"),
            requiredTools = emptyList(),
            description = "Sdraiati a pancia in giù con le mani dietro la testa. Solleva il busto dal pavimento contraendo i muscoli della schiena.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "back_extension"
        ),

        // Gambe
        Exercise(
            name = "Bodyweight Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = emptyList(),
            description = "In piedi con i piedi alla larghezza delle spalle. Abbassa il corpo piegando le ginocchia e spingendo i glutei indietro.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "bodyweight_squat"
        ),
        Exercise(
            name = "Jump Squats",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Calves"),
            requiredTools = emptyList(),
            description = "Esegui uno squat e poi esplodi verso l'alto saltando. Atterra dolcemente e ripeti.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "jump_squat"
        ),
        Exercise(
            name = "Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings"),
            requiredTools = emptyList(),
            description = "Fai un passo in avanti e abbassa il ginocchio posteriore verso il pavimento. Spingi con la gamba anteriore per tornare alla posizione iniziale.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "lunge"
        ),
        Exercise(
            name = "Jumping Lunges",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes", "Hamstrings", "Calves"),
            requiredTools = emptyList(),
            description = "Esegui un affondo e poi salta cambiando la posizione delle gambe in aria. Atterra dolcemente e ripeti.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "jumping_lunge"
        ),
        Exercise(
            name = "Wall Sit",
            primaryMuscleGroup = "Quadriceps",
            secondaryMuscleGroups = listOf("Glutes"),
            requiredTools = emptyList(),
            description = "Appoggia la schiena al muro e abbassa il corpo fino a formare un angolo di 90 gradi con le ginocchia. Mantieni la posizione.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "wall_sit"
        ),

        // Spalle
        Exercise(
            name = "Pike Push-ups",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Chest"),
            requiredTools = emptyList(),
            description = "In posizione di plank, solleva i glutei formando una V rovesciata. Piega i gomiti abbassando la testa verso il pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "pike_pushup"
        ),
        Exercise(
            name = "Handstand Push-ups",
            primaryMuscleGroup = "Shoulders",
            secondaryMuscleGroups = listOf("Triceps", "Chest"),
            requiredTools = emptyList(),
            description = "In verticale contro il muro, abbassa il corpo piegando i gomiti e poi spingi verso l'alto.",
            difficulty = Difficulty.ADVANCED,
            videoResource = "handstand_pushup"
        ),

        // Core
        Exercise(
            name = "Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Shoulders", "Back"),
            requiredTools = emptyList(),
            description = "In posizione di plank con gli avambracci a terra. Mantieni il corpo in linea retta contraendo gli addominali.",
            difficulty = Difficulty.BEGINNER,
            videoResource = "plank"
        ),
        Exercise(
            name = "Side Plank",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Appoggia un avambraccio a terra e solleva il corpo lateralmente. Mantieni la posizione con il corpo in linea retta.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "side_plank"
        ),
        Exercise(
            name = "Russian Twists",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Siediti con le ginocchia piegate e i piedi sollevati. Ruota il busto da un lato all'altro toccando il pavimento.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "russian_twist"
        ),
        Exercise(
            name = "Leg Raises",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Hip Flexors"),
            requiredTools = emptyList(),
            description = "Sdraiati sulla schiena con le gambe tese. Solleva le gambe fino a 90 gradi e abbassale lentamente.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "leg_raise"
        ),
        Exercise(
            name = "Bicycle Crunches",
            primaryMuscleGroup = "Core",
            secondaryMuscleGroups = listOf("Obliques"),
            requiredTools = emptyList(),
            description = "Sdraiati sulla schiena con le mani dietro la testa. Porta il gomito destro verso il ginocchio sinistro e viceversa.",
            difficulty = Difficulty.INTERMEDIATE,
            videoResource = "bicycle_crunch"
        ),

        // ... existing exercises with tools ...
    )
}
