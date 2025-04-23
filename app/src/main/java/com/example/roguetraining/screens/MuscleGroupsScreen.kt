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

// Enum for macro muscle groups
enum class MacroMuscleGroup(val displayName: String, val muscleGroups: List<String>) {
    PUSH("Push", listOf("Chest", "Shoulders", "Triceps")),
    PULL("Pull", listOf("Back", "Biceps", "Forearms")),
    LEGS("Legs", listOf("Quadriceps", "Hamstrings", "Glutes", "Adductors", "Abductors", "Calves")),
    CORE("Core", listOf("Abs", "Lower back", "Obliques")),
    CUSTOM("Custom", emptyList())
}


@Composable
fun MuscleGroupsScreen(
    onNext: (List<String>) -> Unit,
    onNavigateReady: () -> Unit,
    onBack: () -> Unit
) {
    var selectedGroups by remember { mutableStateOf(emptyList<String>()) }
    var selectedMacroGroup by remember { mutableStateOf<MacroMuscleGroup?>(null) }

    // Colori dell'app
    val backgroundColor = Color(0xFF0A1929)
    val primaryColor = Color(0xFFFF3257)
    val textColor = Color.White
    val inactiveBorderColor = Color.White.copy(alpha = 0.3f)
    val selectedContainerColor = primaryColor.copy(alpha = 0.15f)

    // Function to handle macro group selection
    fun selectMacroGroup(macroGroup: MacroMuscleGroup) {
        selectedMacroGroup = macroGroup
        selectedGroups = when (macroGroup) {
            MacroMuscleGroup.PUSH -> macroGroup.muscleGroups
            MacroMuscleGroup.PULL -> macroGroup.muscleGroups
            MacroMuscleGroup.LEGS -> macroGroup.muscleGroups
            MacroMuscleGroup.CORE -> macroGroup.muscleGroups
            MacroMuscleGroup.CUSTOM -> emptyList()
        }
    }

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

            // Macro Group Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MacroMuscleGroup.values().forEach { macroGroup ->
                    val isSelected = selectedMacroGroup == macroGroup
                    
                    OutlinedButton(
                        onClick = { selectMacroGroup(macroGroup) },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(
                            width = 1.5.dp,
                            color = if (isSelected) primaryColor else inactiveBorderColor
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (isSelected) selectedContainerColor else Color.Transparent,
                            contentColor = textColor
                        ),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text(
                            text = macroGroup.displayName,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Divider
            Divider(
                color = inactiveBorderColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
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
                            // If custom is selected, allow individual selection
                            if (selectedMacroGroup == MacroMuscleGroup.CUSTOM) {
                                selectedGroups = if (isSelected) {
                                    selectedGroups - muscleGroup.name
                                } else {
                                    selectedGroups + muscleGroup.name
                                }
                            } else {
                                // If a macro group is selected, switch to custom mode
                                selectedMacroGroup = MacroMuscleGroup.CUSTOM
                                selectedGroups = if (isSelected) {
                                    selectedGroups - muscleGroup.name
                                } else {
                                    selectedGroups + muscleGroup.name
                                }
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