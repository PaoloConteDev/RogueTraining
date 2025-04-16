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

// Colori coerenti
val backgroundColor = Color(0xFF0A1929)
val primaryColor = Color(0xFFFF3257)
val textColor = Color.White

@Composable
fun DurationScreen(
    onNext: (Int) -> Unit, // Ora passa un intero invece di una stringa
    onBack: () -> Unit
) {
    var selectedDuration by remember { mutableStateOf(2) } // Default è 2 per "Media"
    val durations = listOf("Corta", "Media", "Lunga")
    val durationValues = listOf(1, 2, 3) // Mappatura dei valori numerici per le durate

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Background coerente con altre schermate
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
                "Durata dell'allenamento",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = textColor
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Scegli la durata del tuo allenamento:",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = textColor.copy(alpha = 0.8f)
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp) // Increased spacing
            ) {
                durations.forEachIndexed { index, duration ->
                    OutlinedButton(
                        onClick = { selectedDuration = durationValues[index] },
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 72.dp) // Increased height
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp), // Adjusted shape
                        border = outlinedButtonBorder(selected = selectedDuration == durationValues[index], default = Color.White.copy(alpha = 0.3f)), // Usa la funzione helper
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selectedDuration == durationValues[index]) primaryColor.copy(alpha = 0.15f) else Color.Transparent,
                            contentColor = textColor
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp) // Adjusted padding
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start, // Allineamento a sinistra
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Puoi aggiungere un'icona anche qui se vuoi, simile a TrainingTypeScreen
                            Column(modifier = Modifier.padding(start = 16.dp)) { // Adjusted padding if no icon
                                Text(
                                    text = "$duration (${getDurationDescription(duration)})",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = getDurationDetails(duration), // Aggiungi una descrizione più dettagliata se necessario
                                    style = MaterialTheme.typography.bodySmall,
                                    color = textColor.copy(alpha = 0.8f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f)) // Push button to bottom

                Button(
                    onClick = { onNext(selectedDuration) }, // Passa il valore numerico
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor, // Colore di sfondo del bottone
                        contentColor = Color.White // Colore del testo
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp), // Angoli arrotondati consistenti
                    enabled = selectedDuration > 0 // Bottone abilitato solo se una durata è stata selezionata
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

// Definisci la funzione helper 'outlinedButtonBorder' qui
@Composable
fun outlinedButtonBorder(
    selected: Boolean,
    default: Color
): BorderStroke {
    val primaryColor = Color(0xFFFF3257)
    return BorderStroke(1.5.dp, if (selected) primaryColor else default)
}

// Funzione per descrivere la durata in base al valore numerico
fun getDurationDescription(duration: String): String {
    return when (duration) {
        "Corta" -> "30 min"
        "Media" -> "1 ora"
        "Lunga" -> "1 ora e 30 min"
        else -> ""
    }
}

// Funzione opzionale per dettagli aggiuntivi
fun getDurationDetails(duration: String): String {
    return when (duration) {
        "Corta" -> "Ideale per un allenamento rapido (~4 esercizi)"
        "Media" -> "Sessione standard (~7 esercizi)"
        "Lunga" -> "Allenamento completo (~10 esercizi)"
        else -> ""
    }
}
