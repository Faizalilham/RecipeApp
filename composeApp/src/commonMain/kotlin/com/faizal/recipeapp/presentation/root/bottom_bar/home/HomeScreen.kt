package com.faizal.recipeapp.presentation.root.bottom_bar.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(
    navigateToDetails: () -> Unit,
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
    }
}