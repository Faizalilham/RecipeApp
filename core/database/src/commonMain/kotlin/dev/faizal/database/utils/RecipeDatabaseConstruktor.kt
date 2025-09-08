package dev.faizal.database.utils

import androidx.room.RoomDatabaseConstructor
import dev.faizal.database.FavoriteFoodDatabase

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object RecipeDatabaseConstructor: RoomDatabaseConstructor<FavoriteFoodDatabase> {
    override fun initialize(): FavoriteFoodDatabase
}