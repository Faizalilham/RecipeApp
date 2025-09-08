package com.faizal.recipeapp


import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import com.faizal.recipeapp.presentation.screen.root.RootScreen
import dev.faizal.navigation.RootNavigationGraph
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
@Preview
fun App() {
    MaterialTheme {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        RootNavigationGraph(
            root = { navigateToSettings ->
                RootScreen(
                    drawerState = drawerState,
                    navigateToSettings = {
                        navigateToSettings()
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        )
    }
}