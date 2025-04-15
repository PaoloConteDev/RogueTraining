package com.example.roguetraining.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun setSystemUiStyle() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colorScheme.background.luminance() > 0.5f

    SideEffect {
        systemUiController.setNavigationBarColor(
            color = Color(0xFF081724),
            darkIcons = false
        )
        systemUiController.setStatusBarColor(
            color = Color(0xFF081724),
            darkIcons = useDarkIcons
        )
    }
}