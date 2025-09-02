package com.faizal.recipeapp


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.faizal.recipeapp.navigation.RootNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
@Preview
fun App() {
    MaterialTheme {
        RootNavGraph(rememberNavController())
    }
}