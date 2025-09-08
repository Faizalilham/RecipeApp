package com.faizal.recipeapp


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.faizal.recipeapp.presentation.screen.root.RootScreen
import dev.faizal.navigation.RootNavigationGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            //        RootNavGraph(rememberNavController())
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
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
}