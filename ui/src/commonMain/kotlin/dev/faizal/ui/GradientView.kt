package dev.faizal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import dev.faizal.utils.GradientColors
import dev.faizal.utils.GradientType

@Composable
fun GradientView(
    modifier: Modifier = Modifier,
    gradientType: GradientType = GradientType.DARK_TO_WHITE,
    content: @Composable () -> Unit = {}
) {

    val colors = when (gradientType) {
        GradientType.DARK_TO_WHITE -> GradientColors.darkToWhite
        GradientType.BLACK_TO_WHITE -> GradientColors.blackToWhite
        GradientType.BLUE -> GradientColors.blueGradient
        GradientType.SUNSET -> GradientColors.sunset
        GradientType.HOME -> GradientColors.homeGradient
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = colors,
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
    ) {
        content()
    }
}
