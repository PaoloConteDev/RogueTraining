package com.example.roguetraining.models

import com.example.roguetraining.R

// Data class rappresentante un gruppo muscolare
data class MuscleGroup(
    val name: String,          // Nome in inglese per identificazione
    val translation: String,   // Traduzione in italiano per UI
    val imageResId: Int        // ID risorsa immagine
)

// Oggetto contenitore con tutti i gruppi muscolari
object MuscleGroups {
    // Icona di fallback (assicurati che esista in res/drawable)
    private val fallbackIconResId = android.R.drawable.ic_delete

    // Lista di tutti i gruppi muscolari disponibili
    val all = listOf(
        MuscleGroup("Neck", "Collo", R.drawable.icon_neck),
        MuscleGroup("Trapezius", "Trapezio", R.drawable.icon_trapezius),
        MuscleGroup("Shoulders", "Spalle", R.drawable.icon_shoulder),
        MuscleGroup("Biceps", "Bicipiti", R.drawable.icon_bicepsmuscle),
        MuscleGroup("Triceps", "Tricipiti", R.drawable.icon_triceps),
        MuscleGroup("Forearms", "Avambracci", R.drawable.icon_forearms),
        MuscleGroup("Chest", "Pettorali", R.drawable.icon_chestmuscle),
        MuscleGroup("Back", "Schiena", R.drawable.icon_backmuscle),
        MuscleGroup("Abs", "Addominali", R.drawable.icon_abdominals),
        MuscleGroup("Lower back", "Zona lombare", R.drawable.icon_lowerback),
        MuscleGroup("Adductors", "Adduttori", R.drawable.icon_innerthigh),
        MuscleGroup("Abductors", "Abduttori", R.drawable.icon_outerthigh),
        MuscleGroup("Glutes", "Glutei", R.drawable.icon_glutes),
        MuscleGroup("Hamstrings", "Femorali", R.drawable.icon_hamstrings),
        MuscleGroup("Quadriceps", "Quadricipiti", R.drawable.icon_quadriceps),
        MuscleGroup("Calves", "Polpacci", R.drawable.icon_calves)
        // Aggiungi altri se necessario
    )

    // Mappa per accesso rapido per nome (chiave)
    val map = all.associateBy { it.name }

    // Funzione di utility per ottenere la traduzione
    fun getTranslation(name: String): String {
        return map[name]?.translation ?: name
    }

    // Funzione di utility per ottenere l'ID risorsa immagine in modo sicuro
    fun getSafeImageResourceId(name: String): Int {
        return map[name]?.imageResId ?: fallbackIconResId
    }
} 