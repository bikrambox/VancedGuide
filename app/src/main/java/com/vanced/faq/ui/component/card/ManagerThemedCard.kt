package com.vanced.faq.ui.component.card

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.vanced.faq.ui.component.color.guideThemedCardColor

@Composable
fun GuideClickableThemedCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    GuideCard(
        modifier = modifier,
        shape = shape,
        backgroundColor = guideThemedCardColor(),
        onClick = onClick,
        content = content
    )
}

@Composable
fun GuideThemedCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable () -> Unit,
) {
    GuideCard(
        modifier = modifier,
        shape = shape,
        backgroundColor = guideThemedCardColor(),
        content = content
    )
}