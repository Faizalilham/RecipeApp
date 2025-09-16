package dev.faizal.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import dev.faizal.domain.repository.ThemeRepository
import dev.faizal.shared.utils.PreferencesKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ThemeRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : ThemeRepository {

    override val isDarkMode: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.IS_DARK_MODE] == true
    }

    override suspend fun setDarkMode(isDark: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_DARK_MODE] = isDark
        }
    }

    override suspend fun toggleTheme() {
        dataStore.edit { preferences ->
            val currentMode = preferences[PreferencesKeys.IS_DARK_MODE] == true
            preferences[PreferencesKeys.IS_DARK_MODE] = !currentMode
        }
    }
}