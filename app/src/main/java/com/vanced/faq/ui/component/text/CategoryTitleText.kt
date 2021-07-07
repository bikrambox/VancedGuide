package com.vanced.faq.ui.component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vanced.faq.ui.util.defaultContentPaddingHorizontal

@Composable
fun CategoryTitleText(
    text: String
) {
    GuideText(
        modifier = Modifier.padding(start = defaultContentPaddingHorizontal),
        text = text,
        textStyle = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onSurface
    )
}