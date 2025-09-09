package com.faizal.recipeapp


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import dev.faizal.navigation.RootNavigationGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            //        RootNavGraph(rememberNavController())
            RootNavigationGraph()
        }
    }
}