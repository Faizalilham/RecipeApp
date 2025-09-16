package dev.faizal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faizal.root.RootScreen
import dev.faizal.onboarding.OnBoardingScreen
import dev.faizal.settings.SettingsScreen
import dev.faizal.shared.navigation.Screen

@Composable
fun RootNavigationGraph(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoarding,
    ){

        composable<Screen.OnBoarding> {
            OnBoardingScreen(
                navigateToHome = {
                    navController.navigate(Screen.Root)
                }
            )
        }

        composable<Screen.Root> {
            RootScreen(
                navigateToSettings = {
                    navController.navigate(Screen.Settings)
                }
            )
        }

        composable<Screen.Settings> {
            SettingsScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}