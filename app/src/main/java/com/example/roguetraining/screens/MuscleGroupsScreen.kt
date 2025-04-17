package com.example.roguetraining.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.example.roguetraining.models.MuscleGroups

@Composable
fun MuscleGroupsScreen(
    onNext: (List<String>) -> Unit,
    onNavigateReady: () -> Unit,
    onBack: () -> Unit
) {
    var selectedGroups by remember { mutableStateOf(emptyList<String>()) }

    // Colori dell'app
    val backgroundColor = Color(0xFF0A1929)
    val primaryColor = Color(0xFFFF3257)
    val textColor = Color.White
    val inactiveBorderColor = Color.White.copy(alpha = 0.3f)
    val selectedContainerColor = primaryColor.copy(alpha = 0.15f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
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
                    color = textColor
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Scegli i gruppi muscolari da allenare:",
                style = MaterialTheme.typography.titleMedium.copy(color = textColor.copy(alpha = 0.8f)),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(MuscleGroups.all) { muscleGroup ->
                    val isSelected = muscleGroup.name in selectedGroups

                    OutlinedButton(
                        onClick = {
                            selectedGroups = if (isSelected) {
                                selectedGroups - muscleGroup.name
                            } else {
                                selectedGroups + muscleGroup.name
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 46.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(
                            width = 1.5.dp,
                            color = if (isSelected) primaryColor else inactiveBorderColor
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (isSelected) selectedContainerColor else Color.Transparent,
                            contentColor = textColor
                        ),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = muscleGroup.translation,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(1f)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Image(
                                painter = painterResource(id = muscleGroup.imageResId),
                                contentDescription = muscleGroup.translation,
                                modifier = Modifier
                                    .size(36.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    onNext(selectedGroups)
                    onNavigateReady()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor,
                    contentColor = textColor,
                    disabledContainerColor = primaryColor.copy(alpha = 0.5f),
                    disabledContentColor = textColor.copy(alpha = 0.7f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                enabled = selectedGroups.isNotEmpty()
            ) {
                Text(
                    "Prosegui",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )
            }
        }
    }
}