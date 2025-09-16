package dev.faizal.di


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.faizal.shared.store.createDataStore
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
        single<DataStore<Preferences>> {
            createDataStore(context = get())
        }
    }