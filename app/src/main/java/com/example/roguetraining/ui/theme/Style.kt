package com.example.roguetraining.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.roguetraining.ui.theme.cRed
import com.example.roguetraining.ui.theme.cBlueLight
import com.example.roguetraining.ui.theme.cBlueDark

// Common colors
object AppColors {
    val background = Color(0xFF0A1929)
    val surface = Color(0xFF0A1929)
    val primary = cRed
    val secondary = cBlueLight
    val tertiary = cBlueDark
    val onPrimary = Color.White
    val onSecondary = Color.White
    val onTertiary = Color.White
    val onBackground = Color.White
    val onSurface = Color.White
    val cardBackground = Color.White.copy(alpha = 0.1f)
    val cardBorder = Color.White.copy(alpha = 0.3f)
}

// Common dimensions
object AppDimensions {
    val screenPadding = 20.dp
    val cardPadding = 16.dp
    val buttonPadding = 16.dp
    val cardCornerRadius = 24.dp
    val buttonCornerRadius = 12.dp
}

// Common shapes
object AppShapes {
    val cardShape = RoundedCornerShape(AppDimensions.cardCornerRadius)
    val buttonShape = RoundedCornerShape(AppDimensions.buttonCornerRadius)
}

// Common borders
object AppBorders {
    val cardBorder = BorderStroke(1.dp, AppColors.cardBorder)
}

// Common padding
object AppPadding {
    val buttonPadding = PaddingValues(
        horizontal = AppDimensions.buttonPadding,
        vertical = AppDimensions.buttonPadding / 2
    )
}

// Common composables
@Composable
fun AppBackground() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.background
    ) {
        // Empty content
    }
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = AppShapes.cardShape,
        colors = CardDefaults.cardColors(
            containerColor = AppColors.cardBackground
        ),
        border = AppBorders.cardBorder
    ) {
        Column {
            content()
        }
    }
}

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = AppShapes.buttonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.primary,
            contentColor = AppColors.onPrimary
        ),
        contentPadding = AppPadding.buttonPadding
    ) {
        Row {
            content()
        }
    }
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = AppColors.primary
        )
    ) {
        Row {
            content()
        }
    }
} 