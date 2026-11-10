package com.example.cmp_bookpedia.book.presentation.book_detail

import com.example.cmp_bookpedia.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavouriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}