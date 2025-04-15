package com.example.roguetraining.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roguetraining.R

@Composable
fun WelcomeScreen(
    onStartWorkout: () -> Unit,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.welcomebackground),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Overlay to make text more readable
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0A1929).copy(alpha = 0.7f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo in alto
            Text(
                text = "ROGUETRAINING",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(top = 30.dp)
            )

            // Contenuto centrale
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 40.dp)
            ) {
                Text(
                    text = "Train Smarter.\nLive Better.",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Allenamento personalizzato al tuo servizio",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Piano di allenamento creato su misura in base ai tuoi obiettivi, strumenti e preferenze personali.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }

            // Features
            Column(
                modifier = Modifier.padding(bottom = 40.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Feature(
                    number = "1",
                    title = "Personalizzazione",
                    description = "Programmi adattati alle tue caratteristiche fisiche"
                )
                Feature(
                    number = "2",
                    title = "Varietà",
                    description = "Diversi tipi di allenamento per ogni obiettivo"
                )
                Feature(
                    number = "3",
                    title = "Flessibilità",
                    description = "Adatta in base a frequenza, durata e strumenti disponibili"
                )
            }

            // Pulsante in basso
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 30.dp)
            ) {
                Button(
                    onClick = onStartWorkout,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF3257)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(
                        "START",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    )
                }

                Text(
                    text = "Log In",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White.copy(alpha = 0.7f)
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable { /* Gestisci login in futuro */ }
                )
            }
        }
    }
}

@Composable
private fun Feature(
    number: String,
    title: String,
    description: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFFF3257)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White.copy(alpha = 0.7f)
                )
            )
        }
    }
}