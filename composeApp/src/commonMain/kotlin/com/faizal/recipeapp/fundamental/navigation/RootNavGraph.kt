package com.faizal.recipeapp.fundamental.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.faizal.recipeapp.fundamental.domain.Person
import com.faizal.recipeapp.fundamental.presentation.root.RootScreen
import com.faizal.recipeapp.fundamental.presentation.settings.SettingsScreen
import kotlinx.serialization.json.Json

@Composable
fun RootNavGraph(navController: NavHostController) {

    /**
     * when call inside nav host, animation used to all screen, when inside composable animation used to current screen
     * There are still animations that can be used,such as shrinkIn(), shrinkOut(),shrinkVertically(),
     * shrink Horizontally(), expandIn(), expandOut(), expandVertically(), expandHorizontally(), scaleIn(), scaleOut(),
     */
    NavHost(
        navController = navController,
        startDestination = Screen.Root,
        enterTransition = { slideInHorizontally{ it } },
        exitTransition = { slideOutHorizontally{ -it } },
        popEnterTransition = { slideInHorizontally{ -it } },
        popExitTransition = { slideOutHorizontally{ it } },
    ) {

        composable<Screen.Root>{
            RootScreen(
                navigateToSettings = {
                    navController.navigate(Screen.Settings)
                }
            )
        }

        composable<Screen.Settings>(
            enterTransition = { slideInVertically{it}  + fadeIn() },
            exitTransition = { slideOutVertically{it}  + fadeOut() }
        ){
            SettingsScreen(
                onBackNavigation = {
                    navController.navigateUp()
                }
            )
        }
    }
}

fun String.deserialize() : Person = Json.decodeFromString(this)