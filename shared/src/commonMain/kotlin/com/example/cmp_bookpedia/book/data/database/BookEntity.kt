package com.example.cmp_bookpedia.book.data.database

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val title: String,
    val description: String?,
    val imageUrl: String,
    // Room cant save List
    // Languages can be separated into another tables if app scale
    val languages: List<String>,
    val authors: List<String>,
    val firstPublishYear: String?,
    val ratingAverage: Double?,
    val ratingsCount: Int?,
    val numPagesMedian: Int?,
    val numEdition: Int
)
