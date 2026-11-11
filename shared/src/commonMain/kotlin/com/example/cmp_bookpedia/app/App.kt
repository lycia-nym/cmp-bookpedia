package com.example.cmp_bookpedia.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cmp_bookpedia.book.presentation.SelectedBookViewModel
import com.example.cmp_bookpedia.book.presentation.book_detail.BookDetailAction
import com.example.cmp_bookpedia.book.presentation.book_detail.BookDetailScreenRoot
import com.example.cmp_bookpedia.book.presentation.book_detail.BookDetailViewModel
import com.example.cmp_bookpedia.book.presentation.book_list.BookListScreenRoot
import com.example.cmp_bookpedia.book.presentation.book_list.BookListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.BookGraph
        ) {
            // Graph exist as long as one screen in graph exist
            navigation<Route.BookGraph>(
                startDestination = Route.BookList
            ) {
                composable<Route.BookList> {
                    val viewModel = koinViewModel<BookListViewModel>()

                    // Shared same instance **
                    val selectedBookViewModel =
                        it.sharedKoinViewModel<SelectedBookViewModel>(navController)

                    LaunchedEffect(true) {
                        selectedBookViewModel.onSelectBook(null)
                    }

                    BookListScreenRoot(
                        viewModel = viewModel,
                        onBookClick = { book ->
                            selectedBookViewModel.onSelectBook(book)
                            println("TITLE: ${book.title}")
                            navController.navigate(
                                Route.BookDetail(book.id)
                            )
                        }
                    )
                }

                composable<Route.BookDetail> {
                    val viewModel = koinViewModel<BookDetailViewModel>()
                    // Shared same instance **
                    val selectedBookViewModel =
                        it.sharedKoinViewModel<SelectedBookViewModel>(navController)
                    // Collect state flow as compose state
                    val selectedBook by selectedBookViewModel.selectedBook.collectAsStateWithLifecycle()

                    LaunchedEffect(selectedBook) {
                        selectedBook?.let { selectedBook ->
                            viewModel.onAction(BookDetailAction.OnSelectedBookChange(selectedBook))
                        }
                    }

                    BookDetailScreenRoot(
                        viewModel = viewModel,
                        onBackClick = {
                            navController.navigateUp()
                        }
                    )
                }
            }
        }
    }
}

// Utility fun for shared viewModel
// Scope viewModel from single screen to parent nav graph
@Composable
private inline fun <reified T : ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    // Get graph route (parent) from current route (destination)
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    // Access to backstack entry of current navigation graph
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }

    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}
