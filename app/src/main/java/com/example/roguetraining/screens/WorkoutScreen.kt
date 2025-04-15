package com.example.roguetraining.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roguetraining.WorkoutViewModel
import android.widget.VideoView
import android.net.Uri
import android.widget.ImageView
import android.graphics.drawable.ColorDrawable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel,
    onWorkoutComplete: () -> Unit,
    onBack: () -> Unit
) {
    val workoutSets by viewModel.currentWorkout.collectAsStateWithLifecycle()
    var currentSetIndex by remember { mutableStateOf(0) }
    var currentRepIndex by remember { mutableStateOf(0) }
    var isResting by remember { mutableStateOf(false) }
    var restTime by remember { mutableStateOf(0) }
    var videoError by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()

    // Se non ci sono esercizi, mostra un messaggio e torna indietro
    LaunchedEffect(workoutSets) {
        if (workoutSets.isEmpty()) {
            onBack()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = lazyListState
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Workout",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }

            items(workoutSets.size) { index ->
                val isCurrentExercise = index == currentSetIndex
                val isCompleted = index < currentSetIndex

                if (isCurrentExercise || isCompleted) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .alpha(if (isCompleted) 0.6f else 1f),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.1f)
                        ),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.3f)),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (isCurrentExercise || isCompleted) {
                                // Video Player
                                if (isCurrentExercise) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp)
                                            .padding(bottom = 16.dp)
                                    ) {
                                        if (!videoError) {
                                            AndroidView(
                                                factory = { ctx ->
                                                    VideoView(ctx).apply {
                                                        setOnErrorListener { _, _, _ ->
                                                            videoError = true
                                                            true
                                                        }
                                                    }
                                                },
                                                modifier = Modifier.fillMaxSize(),
                                                update = { videoView ->
                                                    val videoPath = "android.resource://${context.packageName}/raw/${workoutSets[index].exercise.videoResource}"
                                                    videoView.setVideoURI(Uri.parse(videoPath))
                                                    videoView.setOnPreparedListener { mp ->
                                                        mp.isLooping = true
                                                        mp.start()
                                                    }
                                                }
                                            )
                                        } else {
                                            AndroidView(
                                                factory = { ctx ->
                                                    ImageView(ctx).apply {
                                                        setImageDrawable(ColorDrawable(android.graphics.Color.WHITE))
                                                    }
                                                },
                                                modifier = Modifier.fillMaxSize()
                                            )
                                        }
                                    }
                                }

                                // Exercise Info
                                Text(
                                    text = "Exercise ${index + 1} of ${workoutSets.size}",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        color = Color.White
                                    ),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )

                                Text(
                                    text = workoutSets[index].exercise.name,
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        color = Color.White
                                    ),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )

                                Text(
                                    text = workoutSets[index].exercise.description,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.White
                                    ),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )

                                // Current Set Info
                                if (isCurrentExercise) {
                                    if (!isResting) {
                                        Text(
                                            text = "Set ${currentRepIndex + 1} of ${workoutSets[index].sets}",
                                            style = MaterialTheme.typography.titleMedium.copy(
                                                color = Color.White
                                            ),
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(bottom = 8.dp)
                                        )

                                        Text(
                                            text = "${workoutSets[index].reps} reps",
                                            style = MaterialTheme.typography.titleLarge.copy(
                                                color = Color.White
                                            ),
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(bottom = 16.dp)
                                        )
                                    } else {
                                        Text(
                                            text = "Rest Time: $restTime seconds",
                                            style = MaterialTheme.typography.titleLarge.copy(
                                                color = Color.White
                                            ),
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(bottom = 16.dp)
                                        )
                                    }
                                } else if (isCompleted) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Completed",
                                            tint = Color(0xFF4CAF50),
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Completed",
                                            style = MaterialTheme.typography.titleMedium.copy(
                                                color = Color(0xFF4CAF50)
                                            )
                                        )
                                    }
                                }

                                // Mostra il peso raccomandato se disponibile
                                workoutSets[index].recommendedWeight?.let { weight ->
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Peso raccomandato: $weight",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(0xFF4CAF50) // Verde per evidenziare il peso
                                    )
                                }
                            }
                        }
                    }

                    LaunchedEffect(currentSetIndex) {
                        if (isCurrentExercise) {
                            lazyListState.animateScrollToItem(index)
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        // Bottom Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color(0xFF0A1929))
                .padding(20.dp)
        ) {
            if (workoutSets.isNotEmpty()) {
                Button(
                    onClick = {
                        if (isResting) {
                            isResting = false
                            restTime = 0
                        } else {
                            viewModel.markSetComplete(currentSetIndex, currentRepIndex)
                            if (currentRepIndex < workoutSets[currentSetIndex].sets - 1) {
                                currentRepIndex++
                                isResting = true
                                restTime = workoutSets[currentSetIndex].restTime
                                scope.launch {
                                    while (restTime > 0) {
                                        delay(1000)
                                        restTime--
                                    }
                                    isResting = false
                                }
                            } else {
                                if (currentSetIndex < workoutSets.size - 1) {
                                    currentSetIndex++
                                    currentRepIndex = 0
                                    videoError = false
                                } else {
                                    onWorkoutComplete()
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        when {
                            isResting -> "Skip Rest"
                            currentRepIndex < workoutSets[currentSetIndex].sets - 1 -> "Complete Set ${currentRepIndex + 1}"
                            currentSetIndex < workoutSets.size - 1 -> "Next Exercise"
                            else -> "Complete Workout"
                        },
                        color = Color(0xFF0A1929),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
} 