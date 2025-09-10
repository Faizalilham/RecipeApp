package dev.faizal.details.viewmodel

import dev.faizal.domain.model.recipe.Recipe
import dev.faizal.shared.ui.UiText

data class DetailState(
    val recipes : Recipe? = null,
    val isLoading : Boolean = false,
    val errorMessage: UiText? = null
)
