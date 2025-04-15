package com.example.roguetraining.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun MuscleGroupsScreen(
    onNext: (List<String>) -> Unit,
    onNavigateReady: () -> Unit,
    onBack: () -> Unit
) {
    val muscleGroups = mapOf(
        "Neck" to "Collo",
        "Trapezius" to "Trapezio",
        "Shoulders" to "Spalle",
        "Biceps" to "Bicipiti",
        "Triceps" to "Tricipiti",
        "Forearms" to "Avambracci",
        "Chest" to "Pettorali",
        "Back" to "Schiena",
        "Abs" to "Addominali",
        "Lower back" to "Zona lombare",
        "Adductors" to "Adduttori",
        "Abductors" to "Abduttori",
        "Glutes" to "Glutei",
        "Hamstrings" to "Femorali",
        "Quadriceps" to "Quadricipiti",
        "Calves" to "Polpacci"
    )
    var selectedGroups by remember { mutableStateOf(emptyList<String>()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929)) // Sfondo scuro
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "Gruppi muscolari",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Scegli i gruppi muscolari da allenare:",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Lista scrollabile con checkbox personalizzate
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // La lista occupa tutto lo spazio disponibile sopra il bottone
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(muscleGroups.keys.toList()) { group ->
                    OutlinedButton(
                        onClick = {
                            selectedGroups = if (group in selectedGroups) {
                                selectedGroups - group
                            } else {
                                selectedGroups + group
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = if (group in selectedGroups) Color(0xFFFF3257) else Color.Gray.copy(alpha = 0.5f)
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (group in selectedGroups) Color(0xFFFF3257).copy(alpha = 0.2f) else Color.Transparent,
                            contentColor = Color.White
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = muscleGroups[group] ?: group,
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottone Prosegui che rimane fisso in basso
            Button(
                onClick = {
                    onNext(selectedGroups)  // Salva i gruppi selezionati
                    onNavigateReady()  // Vai alla schermata successiva
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF3257),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                enabled = selectedGroups.isNotEmpty() // Il bottone si attiva solo se è selezionato almeno un gruppo
            ) {
                Text(
                    "Prosegui",
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