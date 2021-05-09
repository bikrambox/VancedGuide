package com.vanced.faq.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.vanced.faq.ui.theme.cardColor

@Composable
fun ClickableArrow(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}

@Composable
fun HeaderCard(
    headerName: String,
    headerPadding: Dp = 11.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    GuideCard(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Spacer(modifier = Modifier.size(height = 4.dp, width = 0.dp))
            HeaderView(
                headerName = headerName,
                content = content,
                headerPadding = headerPadding
            )
        }
    }
}

@Composable
fun HeaderView(
    modifier: Modifier = Modifier,
    headerName: String,
    headerPadding: Dp = 11.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Header(headerName = headerName, headerPadding = headerPadding)
        content()
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun Header(
    headerName: String,
    headerPadding: Dp = 11.dp,
) {
    Text(
        headerName.uppercase(),
        letterSpacing = 0.15.em,
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = headerPadding),
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp
    )
}

@Composable
fun GuideCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 12.dp,
    content: @Composable () -> Unit
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        backgroundColor = MaterialTheme.colors.cardColor,
        elevation = 0.dp,
        content = content
    )
}