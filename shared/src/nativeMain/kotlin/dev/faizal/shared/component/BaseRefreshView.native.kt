package dev.faizal.shared.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun BaseRefreshView(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier,
    content: @Composable (() -> Unit)
) {
   content()
}