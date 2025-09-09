package com.faizal.recipeapp.fundamental.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.faizal.recipeapp.fundamental.domain.Person
import com.faizal.recipeapp.fundamental.presentation.root.bottom_bar.home.details.DetailsScreen
import com.faizal.recipeapp.fundamental.presentation.root.bottom_bar.home.HomeScreen
import com.faizal.recipeapp.fundamental.presentation.root.bottom_bar.profile.ProfileScreen

@Composable
fun BottomBarNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier.padding(
            top = paddingValues.calculateTopPadding(),
            bottom = paddingValues.calculateBottomPadding()
        ),
        navController = navController,
        startDestination = Screen.BottomBarGraph
    ){
        navigation<Screen.BottomBarGraph>(
            startDestination = Screen.Home
        ) {
            composable<Screen.Home>{
                HomeScreen(
                    navigateToDetails = {
                        navController.navigate(
                            Screen.Details(
                                id = 1,
                                person = Person(
                                    name = "Faizal",
                                    age = 23,
                                    address = "Jakarta"
                                ).serialize()
                            )
                        )
                    },
                )
            }

            composable<Screen.Details> {
                val id = it.toRoute<Screen.Details>().id
                DetailsScreen(id = id)
            }
        }
        composable<Screen.Profile> {
            ProfileScreen()
        }
    }
}