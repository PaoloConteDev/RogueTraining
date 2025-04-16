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

        // Coefficienti specifici per esercizio (aggiornati per corrispondere ai nomi effettivi nel database)
        private val EXERCISE_COEFFICIENTS = mapOf(
            // Esercizi per il petto
            "Barbell Bench Press" to 1.2,
            "Incline Barbell Bench Press" to 1.1,
            "Dumbbell Bench Press" to 0.9,
            "Incline Dumbbell Press" to 0.85,
            "Dumbbell Flyes" to 0.6,
            "Push-Up" to 0.4,
            "Decline Push-Up" to 0.45,
            "Incline Push-Up" to 0.35,
            "Diamond Push-Up" to 0.45,
            "Machine Chest Press" to 1.0,
            "Smith Machine Bench Press" to 1.1,
            "Cable Flyes" to 0.55,
            
            // Esercizi per la schiena
            "Pull-Up" to 0.5,
            "Chin-Up" to 0.55,
            "Lat Pulldown" to 0.8,
            "Barbell Row" to 1.0,
            "Dumbbell Row" to 0.7,
            "Face Pull" to 0.4,
            "Seated Cable Row" to 0.9,
            
            // Esercizi per le gambe
            "Barbell Squat" to 1.3,
            "Deadlift" to 1.4,
            "Romanian Deadlift" to 1.2,
            "Leg Press" to 2.0,
            "Forward Lunge" to 0.6,
            "Bulgarian Split Squat" to 0.7,
            "Leg Extension" to 0.7,
            "Hamstring Curl" to 0.6,
            "Goblet Squat" to 0.8,
            "Hip Thrust" to 1.1,
            
            // Esercizi per le spalle
            "Barbell Shoulder Press" to 0.9,
            "Dumbbell Shoulder Press" to 0.8,
            "Lateral Raise" to 0.4,
            "Front Raises" to 0.4,
            "Arnold Press" to 0.75,
            "Upright Row" to 0.6,
            
            // Esercizi per i bicipiti
            "Barbell Curl" to 0.5,
            "Dumbbell Curl" to 0.4,
            "Hammer Curl" to 0.45,
            "Preacher Curl" to 0.5,
            "Wrist Curl" to 0.3,
            
            // Esercizi per i tricipiti
            "Tricep Pushdown" to 0.4,
            "Skull Crushers" to 0.45,
            "Overhead Tricep Extension" to 0.4,
            "Bench Dips" to 0.3,
            "Parallel Bar Dips" to 0.55,
            
            // Esercizi per il core
            "Plank" to 0.2,
            "Russian Twists" to 0.3,
            "Weighted Plank" to 0.35,
            "Leg Raises" to 0.25,
            "Bicycle Crunch" to 0.2,
            "Cable Crunch" to 0.5,
            "Pallof Press" to 0.4,
            "Cable Rotation" to 0.4
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
                
                // Calcola il range di peso
                var minWeight = (baseWeight * 0.9).toInt()
                var maxWeight = (baseWeight * 1.1).toInt()
                
                // Arrotonda i pesi a valori più "solidi"
                minWeight = arrotondaPeso(minWeight)
                maxWeight = arrotondaPeso(maxWeight)
                
                // Assicurati che ci sia una differenza minima tra min e max
                if (maxWeight <= minWeight) {
                    maxWeight = minWeight + 5
                }
                
                return Pair(minWeight, maxWeight)
            } catch (e: Exception) {
                Log.e("WeightCalculator", "Error calculating weight range: ${e.message}")
                e.printStackTrace()
                return Pair(0, 0)
            }
        }
        
        // Funzione per arrotondare i pesi a valori più "solidi"
        private fun arrotondaPeso(peso: Int): Int {
            // Arrotonda a multipli di 5 per pesi > 10kg
            return if (peso > 10) {
                (peso / 5) * 5 + if (peso % 5 >= 3) 5 else 0
            } else if (peso > 5) {
                // Arrotonda a multipli di 2 per pesi tra 5-10kg
                (peso / 2) * 2 + if (peso % 2 >= 1) 2 else 0
            } else {
                // Pesi molto leggeri rimangono invariati
                peso
            }
        }
    }
} 