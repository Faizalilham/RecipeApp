package com.faizal.recipeapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform