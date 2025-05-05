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
import com.example.roguetraining.WorkoutViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WelcomeScreen(
    onStartWorkout: () -> Unit,
    onBack: () -> Unit,
    viewModel: WorkoutViewModel
) {
    var showLanguageMenu by remember { mutableStateOf(false) }
    val language by viewModel.language.collectAsStateWithLifecycle()

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
            // Language selection button at the top
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp, end = 2.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF0A1929).copy(alpha = 0.7f),
                            shape = RoundedCornerShape(2.dp)
                        )
                        .size(32.dp)
                ) {
                    TextButton(
                        onClick = { showLanguageMenu = true },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = when (language) {
                                "it" -> "🇮🇹"
                                "en" -> "🇬🇧"                          
                                "es" -> "🇪🇸"
                                else -> "🌐"
                            },
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        )
                    }

                    DropdownMenu(
                        expanded = showLanguageMenu,
                        onDismissRequest = { showLanguageMenu = false },
                        modifier = Modifier.background(Color(0xFF0A1929))
                    ) {
                        DropdownMenuItem(
                            text = { 
                                Text(
                                    "🇮🇹 Italiano",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            },
                            onClick = {
                                viewModel.setLanguage("it")
                                showLanguageMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { 
                                Text(
                                    "🇬🇧 English",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            },
                            onClick = {
                                viewModel.setLanguage("en")
                                showLanguageMenu = false
                            }         
                        )
                        DropdownMenuItem(
                            text = { 
                                Text(
                                    "🇪🇸 Español",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            },
                            onClick = {
                                viewModel.setLanguage("es")
                                showLanguageMenu = false
                            }
                        )
                    }
                }
            }

            // Logo in alto
            Text(
                text = "ROGUE TRAINING",
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
                    text = "Allenamento personalizzato al tuo servizio",
                    style = MaterialTheme.typography.displaySmall.copy(
                        color = Color.White,
                        fontSize = 28.sp
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 32.dp),
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
                modifier = Modifier.padding(bottom = 10.dp)
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