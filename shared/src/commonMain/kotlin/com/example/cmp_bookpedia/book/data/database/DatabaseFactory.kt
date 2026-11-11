package com.example.cmp_bookpedia.book.data.database

import androidx.room3.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<FavoriteBookDatabase>
}