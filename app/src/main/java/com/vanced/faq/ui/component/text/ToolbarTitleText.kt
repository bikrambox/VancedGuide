package com.vanced.faq.ui.component.text

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ToolbarTitleText(
    text: String
) {
    GuideText(
        text = text,
        textStyle = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onSurface
    )
}