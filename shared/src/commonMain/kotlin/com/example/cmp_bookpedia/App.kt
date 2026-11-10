package com.example.cmp_bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.cmp_bookpedia.book.data.network.KtorRemoteBookDatasource
import com.example.cmp_bookpedia.book.data.repository.DefaultBookRepository
import com.example.cmp_bookpedia.book.presentation.book_list.BookListScreenRoot
import com.example.cmp_bookpedia.book.presentation.book_list.BookListViewModel
import com.example.cmp_bookpedia.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.koin.compose.viewmodel.koinViewModel

@Composable

fun App() {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = viewModel,
        onBookClick = {

        }
    )
}