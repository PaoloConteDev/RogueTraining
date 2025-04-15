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
fun ToolsScreen(
    onNext: (List<String>) -> Unit
) {
    var selectedTools by remember { mutableStateOf(emptyList<String>()) }
    val toolsOptions = listOf(
        "Pesi piccoli", "Barre", "Panche e rack", "Macchinari",
        "Fasce di resistenza", "Corde"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A1929))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "Strumenti",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                "Scegli gli strumenti che hai a disposizione:",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Lista scrollabile che si ferma prima del bottone
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Occupa tutto lo spazio disponibile sopra il bottone
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(toolsOptions) { tool ->
                    OutlinedButton(
                        onClick = {
                            selectedTools = if (tool in selectedTools) {
                                selectedTools - tool
                            } else {
                                selectedTools + tool
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = if (tool in selectedTools) Color(0xFFFF3257) else Color.Gray.copy(alpha = 0.5f)
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (tool in selectedTools) Color(0xFFFF3257).copy(alpha = 0.2f) else Color.Transparent,
                            contentColor = Color.White
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = tool,
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottone Avanti che rimane fisso in basso
            Button(
                onClick = { onNext(selectedTools) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF3257),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                enabled = selectedTools.isNotEmpty()
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
