package com.example.roguetraining.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roguetraining.models.TrainingIntensity

@Composable
fun IntensityScreen(
    onNext: (String) -> Unit,
    onBack: () -> Unit
) {
    var selectedIntensity by remember { mutableStateOf<TrainingIntensity?>(TrainingIntensity.MEDIUM) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Select Training Intensity",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        IntensityButton(
            intensity = TrainingIntensity.LOW,
            selected = selectedIntensity == TrainingIntensity.LOW,
            onClick = { selectedIntensity = TrainingIntensity.LOW }
        )

        IntensityButton(
            intensity = TrainingIntensity.MEDIUM,
            selected = selectedIntensity == TrainingIntensity.MEDIUM,
            onClick = { selectedIntensity = TrainingIntensity.MEDIUM }
        )

        IntensityButton(
            intensity = TrainingIntensity.HIGH,
            selected = selectedIntensity == TrainingIntensity.HIGH,
            onClick = { selectedIntensity = TrainingIntensity.HIGH }
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { selectedIntensity?.let { onNext(it.toString()) } },
            enabled = selectedIntensity != null,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}

@Composable
private fun IntensityButton(
    intensity: TrainingIntensity,
    selected: Boolean,
    onClick: () -> Unit
) {
    val buttonText = when (intensity) {
        TrainingIntensity.LOW -> "Low Intensity"
        TrainingIntensity.MEDIUM -> "Medium Intensity"
        TrainingIntensity.HIGH -> "High Intensity"
    }

    val description = when (intensity) {
        TrainingIntensity.LOW -> "Light exercises, longer rest periods"
        TrainingIntensity.MEDIUM -> "Balanced workout, moderate rest"
        TrainingIntensity.HIGH -> "Intense exercises, shorter rest periods"
    }

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
