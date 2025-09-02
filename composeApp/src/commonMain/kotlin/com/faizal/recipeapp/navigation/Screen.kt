package com.faizal.recipeapp.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object Home : Screen()

    @Serializable
    data class Details(
        val id : Int = 0,
        val person : String,
    ) : Screen()

    @Serializable
    data object Settings : Screen()
}