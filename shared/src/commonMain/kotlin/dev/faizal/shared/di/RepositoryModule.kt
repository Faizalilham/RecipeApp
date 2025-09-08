package dev.faizal.shared.di

import dev.faizal.shared.domain.RecipeRepository
import org.koin.dsl.module

val repositoryModule = module{
    single { RecipeRepository() }
}