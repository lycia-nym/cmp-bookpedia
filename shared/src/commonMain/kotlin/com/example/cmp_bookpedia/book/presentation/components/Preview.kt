package com.example.cmp_bookpedia.book.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cmp_bookpedia.book.domain.Book
import com.example.cmp_bookpedia.book.presentation.book_list.BookListScreen
import com.example.cmp_bookpedia.book.presentation.book_list.BookListState
import com.example.cmp_bookpedia.book.presentation.book_list.books

@Preview
@Composable
private fun Preview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "",
            onSearchQueryChanged = {},
            onImeSearch = {},
            modifier = Modifier
        )
    }
}



@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = books
        ),
        onAction = {}
    )
}

