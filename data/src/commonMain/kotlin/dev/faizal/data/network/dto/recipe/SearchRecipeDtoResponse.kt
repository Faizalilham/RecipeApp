package dev.faizal.data.network.dto.recipe

data class SearchRecipeDtoResponse(
    val results : List<RecipeDto>,
    val offset : Int,
    val number : Int,
    val totalResults : Int
)
