package com.example.cmp_bookpedia.book.presentation.book_list

import com.example.cmp_bookpedia.book.domain.Book
import com.example.cmp_bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = books,
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null,
)

 val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://test.com",
        authors = listOf("Philip"),
        description = "Description $it",
        language = emptyList(),
        firstPublishYear = null,
        averageRating = 4.5512,
        ratingCount = 6,
        numPages = 100,
        numEdition = 3

    )
}