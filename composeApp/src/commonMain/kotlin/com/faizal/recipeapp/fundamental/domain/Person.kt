package com.faizal.recipeapp.fundamental.domain

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Serializable
data class Person(
    val name: String,
    val age: Int,
    val address: String,
) {
    fun serialize(): String = Json.encodeToString(this)
}