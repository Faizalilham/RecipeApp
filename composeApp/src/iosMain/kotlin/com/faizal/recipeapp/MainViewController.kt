package com.faizal.recipeapp

import androidx.compose.ui.window.ComposeUIViewController
import com.faizal.recipeapp.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }