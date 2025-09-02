package com.faizal.recipeapp.presentation.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    navigateToDetails: () -> Unit,
    navigateToSettings: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = navigateToDetails
        ){
            Text(text = "Go To Details")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = navigateToSettings
        ){
            Text(text = "Go To Settings")
        }
    }
}