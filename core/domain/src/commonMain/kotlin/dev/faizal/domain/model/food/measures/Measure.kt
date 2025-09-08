package dev.faizal.domain.model.food.measures

import kotlinx.serialization.SerialName

data class Measure(
    val amount: Double,
    val unitShort: String?,
    val unitLong: String?
)
