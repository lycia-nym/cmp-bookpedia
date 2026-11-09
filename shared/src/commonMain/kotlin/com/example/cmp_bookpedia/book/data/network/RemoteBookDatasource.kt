package com.example.cmp_bookpedia.book.data.network

import com.example.cmp_bookpedia.book.data.dto.SearchResponseDto
import com.example.cmp_bookpedia.core.domain.DataError
import com.example.cmp_bookpedia.core.domain.Result

interface RemoteBookDatasource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}