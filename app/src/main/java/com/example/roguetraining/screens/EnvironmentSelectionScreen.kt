package com.example.roguetraining.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.roguetraining.database.TrainingEnvironmentDatabase
import com.example.roguetraining.models.TrainingEnvironment

@Composable
fun EnvironmentSelectionScreen(
    onEnvironmentSelected: (String) -> Unit,
    onBack: () -> Unit
) {
    var selectedEnvironment by remember { mutableStateOf<TrainingEnvironment?>(TrainingEnvironmentDatabase.environments[1]) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Select Your Training Environment",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                text = "Choose the type of facility where you typically train",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(TrainingEnvironmentDatabase.environments) { environment ->
                    EnvironmentCard(
                        environment = environment,
                        isSelected = environment == selectedEnvironment,
                        onClick = { selectedEnvironment = environment }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { selectedEnvironment?.let { onEnvironmentSelected(it.name) } },
                enabled = selectedEnvironment != null,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    "Next",
                    color = Color(0xFF0A1929),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun EnvironmentCard(
    environment: TrainingEnvironment,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.White else Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = environment.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = if (isSelected) Color(0xFF0A1929) else Color.White
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = environment.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = if (isSelected) Color(0xFF0A1929) else Color.White
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = "Typical Equipment:",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = if (isSelected) Color(0xFF0A1929) else Color.White
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            
            Text(
                text = environment.typicalTools.take(3).joinToString(", ") + 
                      if (environment.typicalTools.size > 3) "..." else "",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = if (isSelected) Color(0xFF0A1929) else Color.White
                )
            )
        }
    }
} 