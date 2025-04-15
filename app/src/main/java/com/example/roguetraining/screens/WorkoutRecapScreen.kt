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
import com.example.roguetraining.ui.theme.AppBackground
import com.example.roguetraining.ui.theme.AppButton
import com.example.roguetraining.ui.theme.AppCard
import com.example.roguetraining.ui.theme.AppColors
import com.example.roguetraining.ui.theme.AppDimensions

@Composable
fun WorkoutRecapScreen(
    viewModel: WorkoutViewModel,
    onStartWorkout: () -> Unit,
    onBack: () -> Unit
) {
    val sex = viewModel.sex.collectAsStateWithLifecycle().value
    val weight = viewModel.weight.collectAsStateWithLifecycle().value
    val height = viewModel.height.collectAsStateWithLifecycle().value
    val age = viewModel.age.collectAsStateWithLifecycle().value
    val frequency = viewModel.frequency.collectAsStateWithLifecycle().value
    val duration = viewModel.duration.collectAsStateWithLifecycle().value
    val intensity = viewModel.intensity.collectAsStateWithLifecycle().value
    val environment = viewModel.environment.collectAsStateWithLifecycle().value
    val tools = viewModel.tools.collectAsStateWithLifecycle().value
    val muscleGroups = viewModel.muscleGroups.collectAsStateWithLifecycle().value
    val trainingType = viewModel.trainingType.collectAsStateWithLifecycle().value

    // Format duration for display
    val formattedDuration = when (duration) {
        30 -> "30 minuti"
        60 -> "1 ora"
        90 -> "1 ora e 30 minuti"
        else -> "$duration minuti"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.screenPadding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Riepilogo Allenamento",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            color = AppColors.onBackground
        )

        // Personal Information Card
        AppCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(AppDimensions.cardPadding)
            ) {
                Text(
                    text = "Informazioni Personali",
                    style = MaterialTheme.typography.titleLarge,
                    color = AppColors.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                InfoRow("Sesso", sex)
                InfoRow("Peso", "$weight kg")
                InfoRow("Altezza", "$height cm")
                InfoRow("Età", "$age anni")
            }
        }

        // Training Preferences Card
        AppCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(AppDimensions.cardPadding)
            ) {
                Text(
                    text = "Preferenze di Allenamento",
                    style = MaterialTheme.typography.titleLarge,
                    color = AppColors.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                InfoRow("Tipo di Allenamento", trainingType)
                InfoRow("Frequenza", "$frequency volte a settimana")
                InfoRow("Durata", formattedDuration)
                InfoRow("Intensità", intensity?.name ?: "Non impostata")
                InfoRow("Ambiente", environment?.name ?: "Non impostato")
                // InfoRow("Strumenti", tools.joinToString(", "))
                InfoRow("Gruppi Muscolari", muscleGroups.joinToString(", "))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        AppButton(
            onClick = onStartWorkout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Inizia Allenamento")
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = AppColors.onSurface.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = AppColors.onSurface
        )
    }
} 