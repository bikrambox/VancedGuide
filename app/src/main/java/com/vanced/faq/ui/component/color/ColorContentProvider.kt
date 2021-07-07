package com.vanced.faq.ui.component.color

import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ThemedItemContentColorProvider(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColorForColor(MaterialTheme.colors.primary),
        content = content
    )
}