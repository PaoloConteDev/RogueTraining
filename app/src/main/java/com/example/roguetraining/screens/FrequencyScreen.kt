package com.example.roguetraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roguetraining.models.TrainingIntensity

@Composable
fun FrequencyScreen(
    onNext: (Int) -> Unit,
    onBack: () -> Unit
) {
    // Stato per il numero di giorni selezionati con lo slider
    var sessionsPerWeek by remember { mutableStateOf(3f) }
    
    // Mappatura del numero di sessioni alla frequenza (TrainingIntensity)
    val trainingIntensity = when {
        sessionsPerWeek.toInt() <= 2 -> TrainingIntensity.LOW      // 1-2 giorni = Bassa
        sessionsPerWeek.toInt() <= 4 -> TrainingIntensity.MEDIUM   // 3-4 giorni = Media
        else -> TrainingIntensity.HIGH                             // 5+ giorni = Alta
    }

    // Colori coerenti con il resto dell'app
    val backgroundColor = Color(0xFF0A1929)    // Sfondo scuro
    val primaryColor = Color(0xFFFF3257)       // Rosso/Rosa primario 
    val textColor = Color.White                // Testo bianco
    val infoBoxColor = Color(0xFF1E3B5E)       // Box info più scuro
    val infoIconColor = primaryColor           // Icona info con colore primario

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Titolo
            Text(
                text = "Frequenza Allenamento",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = textColor,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Sottotitolo
            Text(
                text = "Seleziona quante volte alla settimana vuoi allenarti",
                style = MaterialTheme.typography.bodyMedium,
                color = textColor.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Numero grande per le sessioni selezionate
            Text(
                text = "${sessionsPerWeek.toInt()}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = primaryColor,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            
            // Testo "sessioni a settimana"
            Text(
                text = "sessioni a settimana",
                style = MaterialTheme.typography.bodyMedium,
                color = textColor.copy(alpha = 0.8f)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Slider per selezionare le sessioni
            Slider(
                value = sessionsPerWeek,
                onValueChange = { sessionsPerWeek = it },
                valueRange = 1f..7f,
                steps = 5, // 7-1-1 = 5 passi
                colors = SliderDefaults.colors(
                    thumbColor = primaryColor,
                    activeTrackColor = primaryColor,
                    inactiveTrackColor = Color.White.copy(alpha = 0.3f)
                ),
                modifier = Modifier.fillMaxWidth()
            )
            
            // Indicatori min-max
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "1",
                    style = MaterialTheme.typography.bodyMedium,
                    color = textColor.copy(alpha = 0.7f)
                )
                Text(
                    text = "7",
                    style = MaterialTheme.typography.bodyMedium,
                    color = textColor.copy(alpha = 0.7f)
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Box con suggerimento
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = infoBoxColor
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "Info",
                        tint = infoIconColor,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Text(
                        text = "Consigliamo 3 sessioni settimanali per ottenere i migliori risultati mantenendo un buon equilibrio con i tempi di recupero.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = textColor
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Pulsante Avanti
            Button(
                onClick = { onNext(sessionsPerWeek.toInt()) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor
                )
            ) {
                Text(
                    text = "Avanti",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}