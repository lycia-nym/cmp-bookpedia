package com.example.cmp_bookpedia.book.domain

import com.example.cmp_bookpedia.core.domain.DataError
import com.example.cmp_bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}