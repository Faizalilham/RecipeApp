package com.faizal.recipeapp.fundamental.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.faizal.recipeapp.fundamental.navigation.Screen

sealed class BottomBarDestination(
    val screen : Screen,
    val icon : ImageVector
){
    data object Home : BottomBarDestination(
        screen = Screen.Home,
        icon = Icons.Default.Home
    )
    data object Profile : BottomBarDestination(
        screen = Screen.Profile,
        icon = Icons.Default.Person
    )
}

val bottomBarDestination = listOf(
    BottomBarDestination.Home,
    BottomBarDestination.Profile
)