package com.vanced.faq.ui.component.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.vanced.faq.R
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun GuideMarkdownText(
    text: String
) {
    MarkdownText(
        markdown = text,
        fontSize = 13.sp,
        fontResource = R.font.inter_regular
    )
}