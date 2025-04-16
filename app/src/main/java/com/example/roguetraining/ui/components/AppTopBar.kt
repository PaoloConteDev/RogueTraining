package com.example.roguetraining.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.roguetraining.models.Exercise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    navController: NavController,
    progress: Float,
    onSkip: () -> Unit = {}
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: "welcome"
    val showBackButton = currentRoute != "welcome" && currentRoute != "finish" && currentRoute != "summary"
    val showSkipButton = currentRoute != "welcome" && currentRoute != "workout" && currentRoute != "finish" && currentRoute != "summary"

    val isInWorkoutFlow = currentRoute == "workout" || currentRoute == "recap" || currentRoute == "finish" || currentRoute == "summary"

    if (!isInWorkoutFlow) {
        Column {
            TopAppBar(
                title = { 
                    if (showBackButton || showSkipButton) {
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .height(2.dp),
                            color = Color(0xFFFF3257)
                        )
                    }
                },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(
                            onClick = { navController.navigateUp() },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color(0xFFFF3257)
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                actions = {
                    if (showSkipButton) {
                        TextButton(
                            onClick = onSkip,
                            modifier = Modifier.padding(end = 8.dp),
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = Color(0xFFFF3257)
                            )
                        ) {
                            Text(
                                text = "Skip",
                                color = Color(0xFFFF3257)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0A1929),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    }
}