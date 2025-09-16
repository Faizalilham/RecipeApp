package dev.faizal.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.faizal.shared.store.createDataStore
import org.koin.dsl.module

actual val platformModule = module {
    single<DataStore<Preferences>> {
        createDataStore()
    }
}