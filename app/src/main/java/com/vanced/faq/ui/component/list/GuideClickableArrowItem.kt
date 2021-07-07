package com.vanced.faq.ui.component.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.vanced.faq.ui.component.text.GuideText
import com.vanced.faq.ui.util.defaultContentPaddingHorizontal
import com.vanced.faq.ui.util.defaultContentPaddingVertical

@Composable
fun GuideClickableArrowItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(
                horizontal = defaultContentPaddingHorizontal,
                vertical = defaultContentPaddingVertical
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        //CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
            GuideText(
                modifier = Modifier
                    .weight(1f),
                text = text,
                textStyle = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSurface
            )
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
       // }
    }
}