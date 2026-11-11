package com.example.cmp_bookpedia.book.data.database

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(FavoriteBookDatabase.DB_NAME)

        return Room.databaseBuilder(
            context = appContext,
            dbFile.absolutePath
        )
    }
}