package com.vanced.faq.ui.component.text

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun GuideText(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textStyle: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = textStyle,
        textAlign = textAlign
    )
}