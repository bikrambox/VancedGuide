package com.vanced.faq.ui.layout.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vanced.faq.domain.model.guide.GuideSingleJsonModel
import com.vanced.faq.ui.component.layout.GuideCategoryLayout
import com.vanced.faq.ui.component.text.GuideMarkdownText
import com.vanced.faq.ui.component.text.GuideText
import com.vanced.faq.ui.util.defaultContentPaddingVertical
import com.vanced.faq.ui.widgets.text.DataFetchFailedText

@Composable
fun GuideLayout(
    data: GuideSingleJsonModel?
) {
    val scrollState = rememberScrollState()
    if (data != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(
                    vertical = defaultContentPaddingVertical
                )
        ) {
            GuideCategoryLayout(categoryName = data.title) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(defaultContentPaddingVertical)
                ) {
                    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
                        if (data.description != null) {
                            GuideMarkdownText(text = data.description)
                        }
                        if (data.fields != null) {
                            data.fields.forEach { field ->
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    GuideText(
                                        text = field.title,
                                        textStyle = MaterialTheme.typography.h4
                                    )
                                    GuideMarkdownText(text = field.content)
                                }
                            }
                        }
                    }
                }
            }
        }
    } else {
        DataFetchFailedText()
    }
}