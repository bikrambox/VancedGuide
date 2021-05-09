package com.vanced.faq.ui.layout.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.vanced.faq.MainViewModel
import com.vanced.faq.ui.component.ClickableArrow
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoriesLayout(
    navController: NavController
) {
    val viewModel: MainViewModel = getViewModel()
    val refreshState = rememberSwipeRefreshState(isRefreshing = viewModel.isFetching)
    val categories by remember { viewModel.categories }
    SwipeRefresh(
        state = refreshState,
        onRefresh = { viewModel.fetch() },
        indicator = { state, refreshTrigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTrigger,
                scale = true
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(categories.toList()) { category ->
                ClickableArrow(text = category.categoryName) {
                    with(navController) {
                        currentBackStackEntry?.arguments?.putParcelable("category", category.data)
                        navigate("category")
                    }
                }
            }
        }
    }
}
