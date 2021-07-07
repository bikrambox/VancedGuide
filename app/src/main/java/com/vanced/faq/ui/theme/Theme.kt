package com.vanced.faq.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF0477E1),
    onSurface = Color(0xFFD7D7D7),
    surface = Color.Black
)

val Colors.cardColor get() = Color(0xFF191919)

@Composable
fun VancedGuideTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}