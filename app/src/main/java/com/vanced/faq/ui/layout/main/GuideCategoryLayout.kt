package com.vanced.faq.ui.layout.main

import android.os.Bundle
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vanced.faq.domain.model.guide.GuideJsonModel
import com.vanced.faq.ui.component.layout.GuideLazyColumn
import com.vanced.faq.ui.component.list.GuideClickableArrowItem
import com.vanced.faq.ui.widgets.text.DataFetchFailedText

@Composable
fun GuideCategoryLayout(
    navController: NavController,
    data: GuideJsonModel?
) {
    GuideLazyColumn {
        if (data != null) {
            items(data.data) { guide ->
                GuideClickableArrowItem(text = guide.title) {
                    with (navController) {
                        currentBackStackEntry?.arguments = Bundle().apply {
                            putParcelable("text", guide)
                        }
                        navigate("guide")
                    }
                }
            }
        } else {
            item {
                DataFetchFailedText()
            }
        }
    }
}