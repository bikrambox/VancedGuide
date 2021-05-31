package com.vanced.faq.ui.layout.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.vanced.faq.MainViewModel
import com.vanced.faq.ui.component.ClickableArrow
import com.vanced.faq.ui.component.DataFetchFailedText
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoriesLayout(
    navController: NavController
) {
    val viewModel: MainViewModel = getViewModel()
    val isFetching by viewModel.isFetching.observeAsState(false)
    val categories by viewModel.categories.observeAsState(emptyList())
    val refreshState = rememberSwipeRefreshState(isRefreshing = isFetching)
    SwipeRefresh(
        state = refreshState,
        onRefresh = { viewModel.fetch() },
        indicator = { state, refreshTriggerDistance ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTriggerDistance,
                scale = true
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            if (categories != null) {
                items(categories!!) { category ->
                    ClickableArrow(text = category.categoryName) {
                        with(navController) {
                            currentBackStackEntry?.arguments?.putParcelable(
                                "category",
                                category.data
                            )
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
