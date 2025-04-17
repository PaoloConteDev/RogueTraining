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
import com.example.roguetraining.models.TrainingIntensity

// Utilizziamo i colori da DurationScreen senza ridefinirli
// I colori saranno accessibili perché entrambi i file sono nello stesso package

@Composable
fun IntensityScreen(
    onNext: (String) -> Unit,
    onBack: () -> Unit
) {
    var selectedIntensity by remember { mutableStateOf(TrainingIntensity.MEDIUM) } // Default è MEDIUM

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Usa il backgroundColor definito in DurationScreen
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
                "Intensità dell'allenamento",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = textColor
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Scegli l'intensità del tuo allenamento:",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = textColor.copy(alpha = 0.8f)
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp) // Increased spacing
            ) {
                TrainingIntensity.values().forEach { intensity ->
                    OutlinedButton(
                        onClick = { selectedIntensity = intensity },
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 72.dp) // Increased height
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp), // Adjusted shape
                        border = outlinedButtonBorder(selected = selectedIntensity == intensity, default = Color.White.copy(alpha = 0.3f)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selectedIntensity == intensity) primaryColor.copy(alpha = 0.15f) else Color.Transparent,
                            contentColor = textColor
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp) // Adjusted padding
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start, // Allineamento a sinistra
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(start = 16.dp)) {
                                Text(
                                    text = getIntensityTitle(intensity),
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = getIntensityDescription(intensity),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = textColor.copy(alpha = 0.8f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f)) // Push button to bottom

                Button(
                    onClick = { onNext(selectedIntensity.toString()) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor, // Colore di sfondo del bottone
                        contentColor = Color.White // Colore del testo
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp), // Angoli arrotondati consistenti
                    enabled = true // Dato che abbiamo un default, il bottone è sempre abilitato
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

// Funzione per ottenere il titolo dell'intensità
fun getIntensityTitle(intensity: TrainingIntensity): String {
    return when (intensity) {
        TrainingIntensity.LOW -> "Bassa intensità"
        TrainingIntensity.MEDIUM -> "Media intensità"
        TrainingIntensity.HIGH -> "Alta intensità"
    }
}

// Funzione per ottenere la descrizione dell'intensità
fun getIntensityDescription(intensity: TrainingIntensity): String {
    return when (intensity) {
        TrainingIntensity.LOW -> "Esercizi leggeri, periodi di riposo più lunghi"
        TrainingIntensity.MEDIUM -> "Allenamento bilanciato, riposo moderato"
        TrainingIntensity.HIGH -> "Esercizi intensi, periodi di riposo brevi"
    }
}