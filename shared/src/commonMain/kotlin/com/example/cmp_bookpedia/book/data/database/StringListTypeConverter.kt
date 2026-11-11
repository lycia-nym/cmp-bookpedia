package com.example.cmp_bookpedia.book.data.database

import androidx.room3.ColumnTypeConverter
import kotlinx.serialization.json.Json


object StringListTypeConverter {

    @ColumnTypeConverter
    fun fromString(value: String): List<String>{
        return Json.decodeFromString(value)
    }

    @ColumnTypeConverter
    fun fromList(list: List<String>): String{
        return Json.encodeToString(list)
    }
}