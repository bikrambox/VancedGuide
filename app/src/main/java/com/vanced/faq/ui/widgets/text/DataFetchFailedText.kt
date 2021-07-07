package com.vanced.faq.ui.widgets.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.vanced.faq.ui.component.text.GuideText

@Composable
fun DataFetchFailedText() {
    GuideText(
        modifier = Modifier.fillMaxWidth(),
        text = "Failed to fetch data",
        textStyle = MaterialTheme.typography.h5,
        textAlign = TextAlign.Center
    )
}