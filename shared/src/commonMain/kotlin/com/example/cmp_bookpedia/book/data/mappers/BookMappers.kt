package com.example.cmp_bookpedia.book.data.mappers

import com.example.cmp_bookpedia.book.data.dto.SearchedBookDto
import com.example.cmp_bookpedia.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-L.jpg"
        },
        authors = authorNames ?: emptyList(),
        description = null,
        language = languages ?: emptyList(),
        firstPublishYear = firstPublicYear.toString(),
        averageRating = ratingAverage,
        ratingCount = ratingCount,
        numPages = numPagesMedian,
        numEdition = numEdition ?: 0,
    )
}