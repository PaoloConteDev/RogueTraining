package com.example.roguetraining.database

data class TrainingType(
    val name: String,
    val description: String,
    val icon: String
)

object TrainingTypeDatabase {
    val allTypes = listOf(
        TrainingType(
            name = "Forza",
            description = "Allenamento focalizzato sulla costruzione di forza e massa muscolare",
            icon = "strength"
        ),
        TrainingType(
            name = "Massa Muscolare",
            description = "Allenamento mirato all'aumento della massa muscolare",
            icon = "muscle"
        ),
        TrainingType(
            name = "Definizione",
            description = "Allenamento per ridurre il grasso corporeo e definire i muscoli",
            icon = "definition"
        ),
        TrainingType(
            name = "Dimagrimento",
            description = "Allenamento combinato per perdere peso in modo efficace",
            icon = "weight_loss"
        ),
        TrainingType(
            name = "Salute e Benessere",
            description = "Allenamento per migliorare la salute generale e il benessere",
            icon = "wellness"
        ),
        TrainingType(
            name = "Performance Sportiva",
            description = "Allenamento specifico per migliorare le prestazioni sportive",
            icon = "performance"
        ),
        TrainingType(
            name = "Misto",
            description = "Combinazione di diversi tipi di allenamento per un approccio completo",
            icon = "mixed"
        )
    )
} 