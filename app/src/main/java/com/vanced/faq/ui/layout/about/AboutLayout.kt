package com.vanced.faq.ui.layout.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vanced.faq.ui.util.defaultContentPaddingVertical
import com.vanced.faq.ui.widgets.about.AboutLinksScroll
import com.vanced.faq.ui.widgets.about.AboutVersionCard

@Composable
fun AboutLayout() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .padding(vertical = defaultContentPaddingVertical),
        verticalArrangement = Arrangement.spacedBy(defaultContentPaddingVertical)
    ) {
        AboutVersionCard()
        AboutLinksScroll()
    }
}