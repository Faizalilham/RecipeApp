package dev.faizal.di


import dev.faizal.details.viewmodel.DetailViewModel
import dev.faizal.home.viewmodel.HomeViewModel
import dev.faizal.saved.SavedViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val koinModules = module{
    viewModel { HomeViewModel(repository = get()) }
    viewModel { DetailViewModel(repository = get()) }
    viewModel { SavedViewModel(repository = get()) }
}