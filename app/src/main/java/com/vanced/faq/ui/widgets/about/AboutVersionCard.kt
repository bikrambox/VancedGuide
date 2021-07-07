package com.vanced.faq.ui.widgets.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vanced.faq.BuildConfig
import com.vanced.faq.R
import com.vanced.faq.ui.component.card.GuideThemedCard
import com.vanced.faq.ui.component.text.GuideText
import com.vanced.faq.ui.util.defaultContentPaddingVertical

@Composable
fun AboutVersionCard() {
    GuideThemedCard(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(vertical = defaultContentPaddingVertical),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            GuideText(
                modifier = Modifier,
                text = stringResource(id = R.string.app_name),
                textStyle = MaterialTheme.typography.h1
            )
            GuideText(
                modifier = Modifier,
                text = BuildConfig.VERSION_NAME,
                textStyle = MaterialTheme.typography.h5
            )
        }
    }
}