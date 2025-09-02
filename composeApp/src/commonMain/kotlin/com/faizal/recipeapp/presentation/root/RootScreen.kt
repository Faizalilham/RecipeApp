package com.faizal.recipeapp.presentation.root


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.faizal.recipeapp.domain.bottomBarDestination
import com.faizal.recipeapp.navigation.BottomBarNavGraph
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.compose.runtime.getValue // for delegation `by`

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen(
    navigateToSettings: () -> Unit,
){
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestinationRoute by remember{
        derivedStateOf { backStackEntry?.destination?.route }
    }

    LaunchedEffect(currentDestinationRoute) {
        println("CURRENT ROUTE : $currentDestinationRoute")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title =
                    {
                        Text(
                            text = currentDestinationRoute
                                ?.substringAfterLast(".")
                                ?.substringBefore("/")
                                ?.substringBefore("?")
                                ?: "Unknown"
                        )
                    },
                navigationIcon = {
                    AnimatedVisibility(
                        visible = currentDestinationRoute?.contains("Details") == true
                    ){
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                actions = {
                    AnimatedVisibility(
                        visible = currentDestinationRoute?.contains("Details") == false
                    ){
                        IconButton(onClick = navigateToSettings) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings"
                            )
                        }
                    }

                }
            )
        },
        bottomBar = {
            NavigationBar {
                bottomBarDestination.forEach { destination ->
                    NavigationBarItem(
                        selected = checkIfSelected(
                            currentDestinationRoute = currentDestinationRoute,
                            currentBottomBarItem = destination.screen.toString()
                        ),
                        label = { Text(text = destination.screen.toString()) },
                        icon = { Icon(imageVector = destination.icon, contentDescription = "Icon") },
                        onClick = {
                            navController.navigate(destination.screen){
                                popUpTo(navController.graph.findStartDestination().route!!){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }

                    )
                }
            }
        }
    ) {
        BottomBarNavGraph(
            navController = navController,
            paddingValues = it
        )
    }
}

private fun checkIfSelected(
    currentDestinationRoute: String?,
    currentBottomBarItem : String
) : Boolean {
    return if((currentDestinationRoute?.contains("Home") == true || currentDestinationRoute?.contains("Details") == true) && currentBottomBarItem == "Home") true
    else if(currentDestinationRoute?.contains(currentBottomBarItem) == true) true
    else false
}