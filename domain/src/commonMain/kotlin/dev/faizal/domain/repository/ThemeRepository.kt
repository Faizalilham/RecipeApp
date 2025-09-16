package dev.faizal.domain.repository

import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    val isDarkMode: Flow<Boolean>
    suspend fun setDarkMode(isDark: Boolean)
    suspend fun toggleTheme()
}