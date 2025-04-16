package com.example.roguetraining.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roguetraining.database.TrainingTypeDatabase
import com.example.roguetraining.database.TrainingType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingTypeScreen(
    onNext: (String) -> Unit,
    onBack: () -> Unit
) {
    var selectedType by remember { mutableStateOf<String?>(null) }
    var errorMessage by remember { mutableStateOf("") }

    val backgroundColor = Color(0xFF0A1929)
    val primaryColor = Color(0xFFFF3257)
    val textColor = Color.White

    Scaffold(
        containerColor = backgroundColor,
        bottomBar = {
            Surface(
                color = backgroundColor,
                shadowElevation = 8.dp
            ) {
                Button(
                    onClick = {
                        selectedType?.let { onNext(it) }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 24.dp, top = 8.dp)
                        .height(56.dp),
                    enabled = selectedType != null,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor,
                        contentColor = Color.White,
                        disabledContainerColor = primaryColor.copy(alpha = 0.5f),
                        disabledContentColor = Color.White.copy(alpha = 0.7f)
                    ),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        "Avanti",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Seleziona il tipo di allenamento",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = textColor
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(TrainingTypeDatabase.allTypes) { type ->
                    TrainingTypeButton(
                        type = type,
                        isSelected = selectedType == type.name,
                        onClick = { selectedType = type.name }
                    )
                }
            }
        }
    }
}

@Composable
fun getIconForTrainingType(iconName: String): ImageVector {
    return when (iconName) {
        "strength" -> Icons.Filled.FitnessCenter
        "muscle" -> Icons.Filled.FitnessCenter
        "definition" -> Icons.Filled.LocalFireDepartment
        "weight_loss" -> Icons.Filled.MonitorWeight
        "wellness" -> Icons.Filled.FavoriteBorder
        "performance" -> Icons.Filled.DirectionsRun
        "mixed" -> Icons.Filled.Shuffle
        else -> Icons.Filled.Warning
    }
}

@Composable
fun TrainingTypeButton(
    type: TrainingType,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val primaryColor = Color(0xFFFF3257)
    val textColor = Color.White
    val borderColor = if (isSelected) primaryColor else Color.White.copy(alpha = 0.3f)
    val containerColor = if (isSelected) primaryColor.copy(alpha = 0.15f) else Color.Transparent
    val contentColor = textColor

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 72.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 1.5.dp,
            color = borderColor
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = getIconForTrainingType(type.icon),
                contentDescription = type.name,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = type.name,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = type.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = textColor.copy(alpha = 0.8f),
                    lineHeight = 16.sp
                )
            }
        }
    }
}
