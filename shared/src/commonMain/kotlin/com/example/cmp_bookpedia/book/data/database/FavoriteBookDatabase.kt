package com.example.cmp_bookpedia.book.data.database

import androidx.room3.ColumnTypeConverter
import androidx.room3.ColumnTypeConverters
import androidx.room3.Database
import androidx.room3.RoomDatabase


@Database(
    entities = [BookEntity::class],
    version = 1
)
@ColumnTypeConverters(
    StringListTypeConverter::class
)
abstract class FavoriteBookDatabase: RoomDatabase() {
    abstract val favoriteBookDao: FavoriteBookDao

    companion object {
        const val DB_NAME = "book.db"
    }
}