package dev.faizal.shared.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
actual fun BaseRefreshView(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    val state = rememberPullRefreshState(isRefreshing, onRefresh)

    Box(
        modifier = modifier.fillMaxSize().pullRefresh(state)
    ) {
        content()
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }