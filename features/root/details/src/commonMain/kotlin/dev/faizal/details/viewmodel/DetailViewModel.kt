package dev.faizal.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.faizal.domain.repository.RecipeRepository
import dev.faizal.shared.ui.toUiText
import dev.faizal.shared.wrapper.onError
import dev.faizal.shared.wrapper.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository : RecipeRepository
) : ViewModel() {

    private var _state = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    fun getSelectedRecipe(id : Int) = viewModelScope.launch {
        _state.update {
            it.copy(isLoading = true)
        }
        repository.getDetailRecipe(id)
            .onSuccess { recipe ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        recipes = recipe
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.toUiText(),
                        recipes = null
                    )
                }
            }

    }
}