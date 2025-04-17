package com.example.roguetraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import com.example.roguetraining.database.TrainingEnvironmentDatabase
import com.example.roguetraining.models.TrainingEnvironment

@Composable
fun EnvironmentSelectionScreen(
    onNext: (TrainingEnvironment) -> Unit,
    onBack: () -> Unit
) {
    var selectedEnvironment by remember { mutableStateOf(TrainingEnvironmentDatabase.environments[1]) } // Default è Medium Gym
    val environments = TrainingEnvironmentDatabase.environments

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "Ambiente di allenamento",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = textColor
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Dove ti allenerai?",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = textColor.copy(alpha = 0.8f)
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                environments.forEach { environment ->
                    OutlinedButton(
                        onClick = { selectedEnvironment = environment },
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 72.dp)
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = outlinedButtonBorder(selected = selectedEnvironment == environment, default = Color.White.copy(alpha = 0.3f)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selectedEnvironment == environment) primaryColor.copy(alpha = 0.15f) else Color.Transparent,
                            contentColor = textColor
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(start = 16.dp)) {
                                Text(
                                    text = environment.name,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = environment.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = textColor.copy(alpha = 0.8f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { onNext(selectedEnvironment) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    enabled = true
                ) {
                    Text(
                        "Avanti",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

// Funzione per ottenere la descrizione dell'ambiente
fun getEnvironmentDescription(environment: String): String {
    return when (environment) {
        "Palestra" -> "Allenamento con attrezzi e macchine specializzate"
        "Casa" -> "Esercizi adattati per uno spazio domestico"
        "All'aperto" -> "Allenamento utilizzando l'ambiente naturale e urbano"
        else -> ""
    }
}