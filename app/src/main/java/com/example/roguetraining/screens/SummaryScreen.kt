package com.example.roguetraining.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.roguetraining.WorkoutViewModel

@Composable
fun SummaryScreen(
    viewModel: WorkoutViewModel,
    workoutDuration: Long,
    onBack: () -> Unit
) {
    // Correggiamo il formato dell'ora per evitare l'ora in più
    val hours = workoutDuration / (1000 * 60 * 60)
    val minutes = (workoutDuration % (1000 * 60 * 60)) / (1000 * 60)
    val seconds = (workoutDuration % (1000 * 60)) / 1000
    val formattedTime = when {
        hours > 0 -> String.format("%d:%02d:%02d", hours, minutes, seconds)
        else -> String.format("%02d:%02d", minutes, seconds)
    }
    
    val workoutSets by viewModel.currentWorkout.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Allenamento Completato!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Durata: $formattedTime",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        
        // Aggiungiamo la lista degli esercizi svolti
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Esercizi completati:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                workoutSets.forEach { workoutSet ->
                    Text(
                        text = "- ${workoutSet.exercise.name} ${workoutSet.sets}x${workoutSet.reps}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Torna alla Home")
        }
    }
} 