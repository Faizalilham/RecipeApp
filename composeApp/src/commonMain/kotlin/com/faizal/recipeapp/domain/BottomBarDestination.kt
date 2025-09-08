package com.faizal.recipeapp.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import dev.faizal.navigation.Screen

sealed class BottomBarDestination(
    val screen: Screen,
    val icon : ImageVector
){
    data object Home : BottomBarDestination(Screen.Home, Icons.Default.Home)
    data object Saved : BottomBarDestination(Screen.Saved, Icons.Default.Star)
    data object Joke : BottomBarDestination(Screen.Joke, Icons.Default.Face)
}


val bottomBarDestinations = listOf(
    BottomBarDestination.Home,
    BottomBarDestination.Saved,
    BottomBarDestination.Joke,
)