package com.vanced.faq.ui.component.layout

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.vanced.faq.ui.theme.cardColor

@Composable
fun GuideSwipeRefresh(
    refreshState: SwipeRefreshState,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    SwipeRefresh(
        state = refreshState,
        onRefresh = onRefresh,
        indicator = { state, refreshTriggerDistance ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTriggerDistance,
                scale = true,
                backgroundColor = MaterialTheme.colors.cardColor,
                contentColor = MaterialTheme.colors.primary
            )
        },
        content = content
    )
}