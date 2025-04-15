package com.example.roguetraining

import android.util.Log
import com.example.roguetraining.models.TrainingIntensity

class WeightCalculator {
    companion object {
        // Coefficienti per il calcolo del peso base
        private const val MALE_BASE_COEFFICIENT = 0.65
        private const val FEMALE_BASE_COEFFICIENT = 0.55
        private const val HEIGHT_COEFFICIENT = 0.002
        private const val AGE_COEFFICIENT = 0.005

        // Coefficienti per l'intensità dell'allenamento
        private val INTENSITY_COEFFICIENTS = mapOf(
            TrainingIntensity.LOW to 0.7,
            TrainingIntensity.MEDIUM to 1.0,
            TrainingIntensity.HIGH to 1.3
        )

        // Coefficienti per gruppo muscolare
        private val MUSCLE_GROUP_COEFFICIENTS = mapOf(
            "Chest" to 1.0,
            "Back" to 0.9,
            "Quadriceps" to 1.1,
            "Hamstrings" to 0.8,
            "Shoulders" to 0.7,
            "Biceps" to 0.6,
            "Triceps" to 0.5,
            "Core" to 0.4
        )

        // Coefficienti specifici per esercizio
        private val EXERCISE_COEFFICIENTS = mapOf(
            // Esercizi per il petto
            "Bench Press" to 1.2,
            "Incline Bench Press" to 1.1,
            "Decline Bench Press" to 1.15,
            "Dumbbell Press" to 0.9,
            "Push-ups" to 0.4,
            "Diamond Push-ups" to 0.45,
            "Wide Push-ups" to 0.35,
            
            // Esercizi per la schiena
            "Pull-ups" to 0.5,
            "Lat Pulldown" to 0.8,
            "Barbell Row" to 1.0,
            "Dumbbell Row" to 0.7,
            "Face Pull" to 0.4,
            
            // Esercizi per le gambe
            "Squat" to 1.3,
            "Deadlift" to 1.4,
            "Leg Press" to 1.2,
            "Lunges" to 0.6,
            "Leg Extension" to 0.7,
            "Leg Curl" to 0.6,
            
            // Esercizi per le spalle
            "Overhead Press" to 0.9,
            "Lateral Raise" to 0.4,
            "Front Raise" to 0.4,
            "Face Pull" to 0.3,
            
            // Esercizi per i bicipiti
            "Barbell Curl" to 0.5,
            "Dumbbell Curl" to 0.4,
            "Hammer Curl" to 0.45,
            "Preacher Curl" to 0.5,
            
            // Esercizi per i tricipiti
            "Tricep Pushdown" to 0.4,
            "Skull Crushers" to 0.45,
            "Diamond Push-ups" to 0.35,
            
            // Esercizi per il core
            "Plank" to 0.2,
            "Russian Twists" to 0.3,
            "Leg Raises" to 0.25,
            "Crunches" to 0.2
        )

        fun calculateWeight(
            sex: String,
            bodyWeight: Float,
            height: Float,
            age: Int,
            intensity: TrainingIntensity,
            muscleGroup: String,
            exerciseName: String
        ): Int {
            try {
                Log.d("WeightCalculator", "Calculating weight for exercise: $exerciseName")
                Log.d("WeightCalculator", "Parameters - Sex: $sex, Weight: $bodyWeight, Height: $height, Age: $age, Muscle: $muscleGroup")

                // Validazione input
                if (bodyWeight <= 0) {
                    Log.w("WeightCalculator", "Invalid body weight: $bodyWeight")
                    return 0
                }
                if (height <= 0) {
                    Log.w("WeightCalculator", "Invalid height: $height")
                    return 0
                }
                if (age <= 0) {
                    Log.w("WeightCalculator", "Invalid age: $age")
                    return 0
                }

                // Calcolo del peso base in base al sesso
                val baseWeight = bodyWeight * if (sex.equals("Male", ignoreCase = true)) 
                    MALE_BASE_COEFFICIENT 
                else 
                    FEMALE_BASE_COEFFICIENT

                // Fattore di altezza (più alto = più peso)
                val heightFactor = 1 + (height * HEIGHT_COEFFICIENT)

                // Fattore età (più giovane = più peso)
                val ageFactor = 1 - ((age - 20) * AGE_COEFFICIENT).coerceAtMost(0.3)

                // Fattore intensità
                val intensityFactor = INTENSITY_COEFFICIENTS[intensity] ?: 1.0

                // Fattore gruppo muscolare
                val muscleGroupFactor = MUSCLE_GROUP_COEFFICIENTS[muscleGroup] ?: 1.0

                // Fattore esercizio specifico
                val exerciseFactor = EXERCISE_COEFFICIENTS[exerciseName] ?: 1.0

                // Calcolo del peso finale
                val finalWeight = baseWeight * heightFactor * ageFactor * intensityFactor * muscleGroupFactor * exerciseFactor

                // Assicuriamoci che il peso non sia mai negativo o zero
                val safeWeight = finalWeight.coerceAtLeast(1.0)

                Log.d("WeightCalculator", "Calculated weight: ${safeWeight.toInt()} kg")
                return safeWeight.toInt()
            } catch (e: Exception) {
                Log.e("WeightCalculator", "Error calculating weight: ${e.message}")
                e.printStackTrace()
                return 0
            }
        }

        fun getWeightRange(
            sex: String,
            bodyWeight: Float,
            height: Float,
            age: Int,
            intensity: TrainingIntensity,
            muscleGroup: String,
            exerciseName: String
        ): Pair<Int, Int> {
            try {
                val baseWeight = calculateWeight(sex, bodyWeight, height, age, intensity, muscleGroup, exerciseName)
                if (baseWeight <= 0) {
                    return Pair(0, 0)
                }
                val minWeight = (baseWeight * 0.8).toInt().coerceAtLeast(1)
                val maxWeight = (baseWeight * 1.2).toInt().coerceAtLeast(minWeight + 1)
                return Pair(minWeight, maxWeight)
            } catch (e: Exception) {
                Log.e("WeightCalculator", "Error calculating weight range: ${e.message}")
                e.printStackTrace()
                return Pair(0, 0)
            }
        }
    }
} 