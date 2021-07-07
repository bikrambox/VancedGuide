package com.vanced.faq.ui.component.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.vanced.faq.ui.component.text.CategoryTitleText
import com.vanced.faq.ui.util.defaultContentPaddingHorizontal
import com.vanced.faq.ui.util.defaultContentPaddingVertical

@Composable
fun GuideCategoryLayout(
    categoryName: String,
    contentPaddingHorizontal: Dp = defaultContentPaddingHorizontal,
    categoryNameSpacing: Dp = defaultContentPaddingVertical,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(categoryNameSpacing),
    ) {
        CategoryTitleText(text = categoryName)
        Box(
            modifier = Modifier.padding(horizontal = contentPaddingHorizontal)
        ) {
            content()
        }
    }
}