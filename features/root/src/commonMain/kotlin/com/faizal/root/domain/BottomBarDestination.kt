package com.faizal.root.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import dev.faizal.shared.navigation.Screen

sealed class BottomBarDestination(
    val screen : Screen,
    val icon : ImageVector
){

    data object Home : BottomBarDestination(
        screen = Screen.Home,
        icon = Icons.Outlined.Home
    )

    data object Saved : BottomBarDestination(
        screen = Screen.Saved,
        icon = Icons.Outlined.Favorite
    )

    data object Joke : BottomBarDestination(
        screen = Screen.Joke,
        icon = Icons.Outlined.Person
    )

}

val bottomBarDestination = listOf(
    BottomBarDestination.Home,
    BottomBarDestination.Saved,
    BottomBarDestination.Joke
)