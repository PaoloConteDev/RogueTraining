package com.example.roguetraining.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.roguetraining.WorkoutViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SummaryScreen(
    viewModel: WorkoutViewModel,
    workoutDuration: Long,
    onBack: () -> Unit
) {
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val duration = dateFormat.format(Date(workoutDuration))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Workout Completed!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Duration: $duration",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Back to Home")
        }
    }
} 