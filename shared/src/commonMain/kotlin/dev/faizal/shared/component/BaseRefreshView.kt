package dev.faizal.shared.component


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun BaseRefreshView(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
)