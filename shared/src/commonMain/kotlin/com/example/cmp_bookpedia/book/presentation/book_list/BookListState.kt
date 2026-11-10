package com.example.cmp_bookpedia.book.presentation.book_list

import com.example.cmp_bookpedia.book.domain.Book
import com.example.cmp_bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favouriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null,
)
