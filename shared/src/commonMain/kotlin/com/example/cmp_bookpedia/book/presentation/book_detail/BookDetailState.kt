package com.example.cmp_bookpedia.book.presentation.book_detail

import com.example.cmp_bookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavourite: Boolean = false,
    val book: Book? = null,
)
