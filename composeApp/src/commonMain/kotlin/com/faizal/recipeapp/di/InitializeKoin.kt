package com.faizal.recipeapp.di

import dev.faizal.di.koinModules
import dev.faizal.di.platformModule
import dev.faizal.di.repositoryModule
import org.koin.core.context.startKoin

fun initializeKoin(){
    startKoin {
        modules(repositoryModule, koinModules, platformModule)
    }
}