package com.vanced.faq.ui.layout.main

import android.graphics.Color
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.vanced.faq.domain.model.guide.GuideSingleJsonModel
import io.noties.markwon.Markwon
import org.koin.androidx.compose.get

@ExperimentalUnsignedTypes
@Composable
fun GuideLayout(
    data: GuideSingleJsonModel?
) {
    val scrollState = rememberScrollState()
    val markwon = get<Markwon>()
    val textColor = Color.WHITE
    if (data != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.title,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                if (data.description != null) {
                    AndroidView(
                        factory = {
                            TextView(it).apply {
                                markwon.setMarkdown(this, data.description)
                                movementMethod = LinkMovementMethod.getInstance()
                                setTextColor(textColor)
                            }
                        }
                    )
                }
                if (data.fields != null) {
                    data.fields.forEach { field ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = field.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        AndroidView(
                            modifier = Modifier.padding(top = 4.dp),
                            factory = {
                                TextView(it).apply {
                                    markwon.setMarkdown(this, field.content)
                                    movementMethod = LinkMovementMethod.getInstance()
                                    setTextColor(textColor)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}