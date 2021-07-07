package com.vanced.faq.ui.component.card

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun GuideLinkCard(
    title: String,
    link: String,
    @DrawableRes icon: Int,
) {
    val uriHandler = LocalUriHandler.current
    GuideClickableItemCard(
        title = title,
        icon = icon
    ) {
        uriHandler.openUri(link)
    }
}