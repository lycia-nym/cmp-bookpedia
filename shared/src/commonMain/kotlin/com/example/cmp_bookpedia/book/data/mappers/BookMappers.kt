package com.example.cmp_bookpedia.book.data.mappers

import com.example.cmp_bookpedia.book.data.database.BookEntity
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
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublicYear.toString(),
        averageRating = ratingAverage,
        ratingCount = ratingCount,
        numPages = numPagesMedian,
        numEdition = numEdition ?: 0,
    )
}

fun Book.toBookEntity(): BookEntity{
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        ratingAverage = averageRating,
        ratingsCount = ratingCount,
        numPagesMedian = numPages,
        numEdition = numEdition
    )
}

fun BookEntity.toBook(): Book{
    return Book(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        averageRating = ratingAverage,
        ratingCount = ratingsCount,
        numPages = numPagesMedian,
        numEdition = numEdition
    )
}