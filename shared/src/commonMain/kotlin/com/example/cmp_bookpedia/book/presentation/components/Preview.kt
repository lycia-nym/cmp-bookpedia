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


private val books = (1..100).map {
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

