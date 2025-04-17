package com.example.roguetraining.screens

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roguetraining.WorkoutViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Colori aggiornati coerenti con l'app
object AppColors {
    val primary = Color(0xFFFF3257)      // Rosso/rosa primario
    val darkBackground = Color(0xFF0A1929) // Sfondo scuro
    val green = Color(0xFF22C55E)        // Verde per elementi completati
    val white = Color.White
    val gray = Color(0xFF9CA3AF)         // Grigio per testo secondario
    val darkText = Color(0xFF1E293B)     // Testo scuro
}

@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel,
    onWorkoutComplete: () -> Unit,
    onBack: () -> Unit
) {
    val workoutSets by viewModel.currentWorkout.collectAsStateWithLifecycle()
    var currentExerciseIndex by remember { mutableStateOf(0) }
    var currentSetIndex by remember { mutableStateOf(0) }
    var isResting by remember { mutableStateOf(false) }
    var remainingRestTime by remember { mutableStateOf(90) } // 1:30 come nell'immagine
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var showDescriptionDialog by remember { mutableStateOf(false) } // Stato per visibilità dialog

    // Timer di riposo che scorre effettivamente
    LaunchedEffect(isResting) {
        if (isResting) {
            coroutineScope.launch {
                while (remainingRestTime > 0 && isResting) {
                    delay(1000)
                    remainingRestTime--
                }
                if (remainingRestTime <= 0) {
                    isResting = false
                }
            }
        }
    }

    // Assicurati che ci siano esercizi disponibili
    if (workoutSets.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColors.darkBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Nessun esercizio disponibile",
                color = AppColors.white
            )
        }
        return
    }

    val currentExercise = workoutSets[currentExerciseIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.darkBackground)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            //shape = RoundedCornerShape(16.dp),
            //elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            //colors = CardDefaults.cardColors(containerColor = AppColors.white)
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Top Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Current Workout",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.white
                    )
                }

                // Video Exercise
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    // Carica il video dalla risorsa
                    AndroidView(
                        factory = { ctx ->
                            VideoView(ctx).apply {
                                setOnPreparedListener { mp ->
                                    mp.isLooping = true
                                    mp.start()
                                }
                            }
                        },
                        modifier = Modifier.fillMaxSize(),
                        update = { videoView ->
                            val videoPath = "android.resource://${context.packageName}/raw/${currentExercise.exercise.videoResource}"
                            videoView.setVideoURI(Uri.parse(videoPath))
                        }
                    )

                    // Box con icona info posizionato con offset preciso
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(end = 16.dp, top = 4.dp) // Usa padding invece di offset
                            .size(18.dp)
                            .background(Color.Black.copy(alpha = 0.4f), CircleShape)
                            .clickable { showDescriptionDialog = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Mostra descrizione esercizio",
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    // Exercise info overlay
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 16.dp, bottom = 2.dp) // Padding per distanziare dal bordo
                    ) {
                        Text(
                            text = currentExercise.exercise.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = AppColors.white,
                            fontWeight = FontWeight.Bold
                        )

                        // Traduci e formatta i muscoli target
                        val primaryMuscleTranslated = MuscleTranslator.translate(currentExercise.exercise.primaryMuscleGroup)
                        val secondaryMusclesTranslated = MuscleTranslator.translateList(currentExercise.exercise.secondaryMuscleGroups)
                        val targetText = buildString {
                            append("Target: ")
                            append(primaryMuscleTranslated)
                            if (secondaryMusclesTranslated.isNotEmpty()) {
                                append(" - ")
                                append(secondaryMusclesTranslated.joinToString(", "))
                            }
                        }

                        Text(
                            text = targetText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppColors.white
                        )
                    }
                }

                // Sets Progress and Weight info
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Sets Progress",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppColors.gray
                        )
                        Text(
                            text = "${currentSetIndex + 1}/${currentExercise.sets}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = AppColors.white
                        )
                    }

                    // Verifica se l'esercizio CORRENTE è completato
                    // Assumendo che WorkoutSet abbia un metodo/proprietà isWorkoutComplete()
                    val isCurrentExerciseComplete = workoutSets.getOrNull(currentExerciseIndex)?.isWorkoutComplete() ?: false

                    Column(horizontalAlignment = Alignment.End) {
                        if (currentExercise.exercise.requiredTools.isNotEmpty()) {
                            Text(
                                text = "Recommended Weight",
                                style = MaterialTheme.typography.bodyMedium,
                                color = AppColors.gray
                            )
                            Text(
                                text = currentExercise.recommendedWeight ?: "N/A",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = AppColors.white
                            )
                        }
                    }
                }

                // Sets list con sovrapposizione del rest timer
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    // Lista dei set
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                            .alpha(if (isResting) 0.3f else 1f) // Semi-trasparente durante il riposo
                    ) {
                        // Genera la lista dei set dinamicamente
                        for (i in 0 until currentExercise.sets) {
                            val isCompleted = i < currentSetIndex
                            val isActive = i == currentSetIndex

                            SetItem(
                                setNumber = i + 1,
                                isCompleted = isCompleted,
                                isActive = isActive,
                                reps = currentExercise.reps
                            )
                        }
                    }

                    // Rest Timer overlay
                    if (isResting) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(16.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = AppColors.gray.copy(alpha = 0.9f)
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "Rest Timer",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = AppColors.white
                                    )

                                    Text(
                                        text = String.format("%02d:%02d", remainingRestTime / 60, remainingRestTime % 60),
                                        style = MaterialTheme.typography.displayMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = AppColors.white
                                    )
                                }
                            }
                        }
                    }
                }

                // Bottom action button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            if (isResting) {
                                // Skip rest
                                isResting = false
                                remainingRestTime = 0
                            } else {
                                // Complete current set
                                viewModel.markSetComplete(currentExerciseIndex, currentSetIndex)

                                if (currentSetIndex < currentExercise.sets - 1) {
                                    // Move to next set and start rest
                                    currentSetIndex++
                                    isResting = true
                                    remainingRestTime = currentExercise.restTime
                                } else if (currentExerciseIndex < workoutSets.size - 1) {
                                    // Move to next exercise
                                    currentExerciseIndex++
                                    currentSetIndex = 0
                                } else {
                                    // Complete workout
                                    onWorkoutComplete()
                                }
                            }
                        },
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = if (isResting) AppColors.primary else AppColors.green)
                    ) {
                        Text(
                            text = if (isResting) "Skip Rest" else "Complete Set",
                            color = AppColors.white,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

        }
    }

    // AlertDialog per la descrizione (fuori dalla Card principale)
    if (showDescriptionDialog) {
        AlertDialog(
            onDismissRequest = { showDescriptionDialog = false }, // Chiudi se si clicca fuori
            title = {
                Text(
                    text = currentExercise.exercise.name,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(currentExercise.exercise.description) // Mostra la descrizione
            },
            confirmButton = {
                TextButton(
                    onClick = { showDescriptionDialog = false } // Bottone per chiudere
                ) {
                    Text("Chiudi")
                }
            },
            // Stile opzionale per il dialog
            containerColor = AppColors.white, // Sfondo dialog
            titleContentColor = AppColors.darkText, // Colore titolo
            textContentColor = AppColors.darkText.copy(alpha = 0.8f) // Colore testo descrizione
        )
    }
}

@Composable
fun SetItem(
    setNumber: Int,
    isCompleted: Boolean = false,
    isActive: Boolean = false,
    reps: Int
) {
    val backgroundColor = when {
        isActive -> Color.Transparent
        else -> Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .border(
                width = if (isActive) 1.dp else 0.dp,
                color = if (isActive) AppColors.primary else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    when {
                        isCompleted -> AppColors.green
                        isActive -> AppColors.primary
                        else -> AppColors.white
                    },
                    CircleShape
                )
                .border(
                    width = 1.dp,
                    color = when {
                        isCompleted -> AppColors.green
                        isActive -> AppColors.primary
                        else -> AppColors.gray
                    },
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isCompleted) {
                Text(
                    text = "✓",
                    color = AppColors.white,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Text(
            text = "Set $setNumber",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp),
            color = when {
                isCompleted -> AppColors.gray  // Colore per set completato
                isActive -> AppColors.white  // Colore per set attivo
                else -> AppColors.white         // Colore per set non ancora attivo
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "$reps reps",
            style = MaterialTheme.typography.bodyLarge,

            color = when {
                isCompleted -> AppColors.gray       // Set completato: colore grigio
                isActive -> AppColors.white      // Set attivo: colore scuro standard
                else -> AppColors.white        // Set non attivo: leggermente meno intenso
            }
        )
    }
}

// Definizione di MuscleTranslator (ora al top-level)
object MuscleTranslator {
    private val translations = mapOf(
        "Neck" to "Collo",
        "Trapezius" to "Trapezio",
        "Shoulders" to "Spalle",
        "Biceps" to "Bicipiti",
        "Triceps" to "Tricipiti",
        "Forearms" to "Avambracci",
        "Chest" to "Pettorali",
        "Back" to "Schiena",
        "Abs" to "Addominali",
        "Core" to "Core",
        "Lower back" to "Zona lombare",
        "Adductors" to "Adduttori",
        "Abductors" to "Abduttori",
        "Glutes" to "Glutei",
        "Hamstrings" to "Femorali",
        "Quadriceps" to "Quadricipiti",
        "Calves" to "Polpacci",
        "Obliques" to "Obliqui",
        "Hip Flexors" to "Flessori dell'anca"
    ).withDefault { it }

    fun translate(muscleName: String): String {
        return translations.getValue(muscleName)
    }

    fun translateList(muscleNames: List<String>): List<String> {
        return muscleNames.map { translate(it) }
    }
} 