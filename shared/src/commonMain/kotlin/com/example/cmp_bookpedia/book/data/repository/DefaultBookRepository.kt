package com.example.cmp_bookpedia.book.data.repository

import com.example.cmp_bookpedia.book.data.mappers.toBook
import com.example.cmp_bookpedia.book.data.network.RemoteBookDatasource
import com.example.cmp_bookpedia.book.domain.Book
import com.example.cmp_bookpedia.book.domain.BookRepository
import com.example.cmp_bookpedia.core.domain.DataError
import com.example.cmp_bookpedia.core.domain.Result
import com.example.cmp_bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDatasource: RemoteBookDatasource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDatasource
            .searchBooks(query)
            .map { dto -> dto.results.map { it.toBook() } }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDatasource
            .getBookDetails(bookId)
            .map { it.description }
    }
}