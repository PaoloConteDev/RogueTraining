package com.example.roguetraining.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roguetraining.database.ToolDatabase
import com.example.roguetraining.models.TrainingEnvironment

@Composable
fun ToolSelectionScreen(
    environment: TrainingEnvironment? = null,
    onToolsSelected: (List<String>) -> Unit,
    onGenerateWorkout: () -> Unit,
    onBack: () -> Unit
) {
    var selectedTools by remember { mutableStateOf(environment?.typicalTools?.toSet() ?: setOf()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (environment != null) {
            Text(
                text = "Personalizza Attrezzatura",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                text = "Based on your ${environment.name} selection",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        } else {
            Text(
                text = "Select Your Tools",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Group tools by category
        val toolsByCategory = ToolDatabase.allTools.groupBy { it.category }

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            toolsByCategory.forEach { (category, tools) ->
                item {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                
                items(tools) { tool ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = selectedTools.contains(tool.name),
                            onCheckedChange = { checked ->
                                selectedTools = if (checked) {
                                    selectedTools + tool.name
                                } else {
                                    selectedTools - tool.name
                                }
                                onToolsSelected(selectedTools.toList())
                            }
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                text = tool.name,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = tool.description,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }

        Button(
            onClick = onGenerateWorkout,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Avanti")
        }
    }
} 