package com.faizal.recipeapp

import androidx.compose.runtime.Composable
import dev.faizal.navigation.RootNavigationGraph
import dev.faizal.theme.FoodAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    FoodAppTheme {
        KoinContext {
            //        RootNavGraph(rememberNavController())
            RootNavigationGraph()
        }
    }
}