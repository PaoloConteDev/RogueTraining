package com.example.roguetraining.screens

import androidx.compose.foundation.BorderStroke
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

@Composable
fun FrequencyScreen(
    onNext: (Int) -> Unit, // Ora passa un intero invece di una stringa
    onBack: () -> Unit
) {
    var selectedFrequency by remember { mutableStateOf(2) } // Default è 2 per "Media"
    val frequencies = listOf("Bassa", "Media", "Alta")
    val frequencyValues = listOf(1, 2, 3) // Mappatura dei valori numerici per le frequenze

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929)) // Background coerente con altre schermate
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
                "Frequenza dell'allenamento",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Scegli la frequenza settimanale del tuo allenamento:",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                frequencies.forEachIndexed { index, frequency ->
                    OutlinedButton(
                        onClick = { selectedFrequency = frequencyValues[index] },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(98.dp)
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = outlinedButtonBorder(selected = selectedFrequency == frequencyValues[index], default = Color.Gray.copy(alpha = 0.5f)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selectedFrequency == frequencyValues[index]) Color(0xFFFF3257).copy(alpha = 0.2f) else Color.Transparent,
                            contentColor = Color.White
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start, // Allineamento a sinistra
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "$frequency (${getFrequencyDescription(frequency)})",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.padding(start = 16.dp) // Padding per allineare il testo
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { onNext(selectedFrequency) }, // Passa il valore numerico
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF3257), // Colore di sfondo del bottone
                        contentColor = Color.White // Colore del testo
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(8.dp), // Angoli arrotondati
                    enabled = selectedFrequency > 0 // Bottone abilitato solo se una frequenza è stata selezionata
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

// Funzione per descrivere la frequenza in base al valore numerico
fun getFrequencyDescription(frequency: String): String {
    return when (frequency) {
        "Bassa" -> "2-3 volte a settimana"
        "Media" -> "3-4 volte a settimana"
        "Alta" -> "5+ volte a settimana"
        else -> ""
    }
}