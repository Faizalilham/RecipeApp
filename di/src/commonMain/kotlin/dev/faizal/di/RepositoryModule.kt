package dev.faizal.di


import dev.faizal.data.network.config.HttpClientFactory
import dev.faizal.data.network.data.KtorRemoteRecipeDataSource
import dev.faizal.data.network.data.RemoteRecipeDataSource
import dev.faizal.data.repository.RecipeRepositoryImpl
import dev.faizal.data.repository.ThemeRepositoryImpl
import dev.faizal.domain.repository.RecipeRepository
import dev.faizal.domain.repository.ThemeRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module
val repositoryModule = module{
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteRecipeDataSource).bind<RemoteRecipeDataSource>()
    singleOf(::RecipeRepositoryImpl).bind<RecipeRepository>()
    singleOf(::ThemeRepositoryImpl).bind<ThemeRepository>()
}