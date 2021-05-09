package com.vanced.faq.ui.layout.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.vanced.faq.domain.model.guide.GuideJsonModel
import com.vanced.faq.ui.component.ClickableArrow
import com.vanced.faq.ui.component.DataFetchFailedText

@Composable
fun CategoryLayout(
    navController: NavController,
    data: GuideJsonModel?
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        if (data != null) {
            items(data.data) { guide ->
                ClickableArrow(text = guide.title) {
                    with (navController) {
                        currentBackStackEntry?.arguments?.putParcelable("text", guide)
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