package com.vanced.faq.ui.widgets.about

import androidx.compose.runtime.Composable
import com.vanced.faq.ui.component.card.GuideLinkCard
import com.vanced.faq.ui.component.layout.GuideCategoryLayout
import com.vanced.faq.ui.component.layout.GuideScrollableItemRow
import util.links

@Composable
fun AboutLinksScroll() {
    GuideCategoryLayout(categoryName = "Official Links") {
        GuideScrollableItemRow(items = links) { link ->
            GuideLinkCard(
                title = link.name,
                icon = link.icon,
                link = link.url
            )
        }
    }
}