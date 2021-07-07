package com.vanced.faq.ui.layout.main

import android.os.Bundle
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.vanced.faq.MainViewModel
import com.vanced.faq.ui.component.layout.GuideLazyColumn
import com.vanced.faq.ui.component.layout.GuideSwipeRefresh
import com.vanced.faq.ui.component.list.GuideClickableArrowItem
import com.vanced.faq.ui.widgets.text.DataFetchFailedText
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoriesLayout(
    navController: NavController
) {
    val viewModel: MainViewModel = getViewModel()
    val isFetching by viewModel.isFetching.observeAsState(false)
    val categories by viewModel.categories.observeAsState(emptyList())
    val refreshState = rememberSwipeRefreshState(isRefreshing = isFetching)
    GuideSwipeRefresh(
        refreshState = refreshState,
        onRefresh = { viewModel.fetch() }
    ) {
        GuideLazyColumn {
            if (categories != null) {
                items(categories!!) { category ->
                    GuideClickableArrowItem(text = category.categoryName) {
                        with(navController) {
                            currentBackStackEntry?.arguments = Bundle().apply {
                                putParcelable("category", category.data)
                            }
                            navigate("category")
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
}
