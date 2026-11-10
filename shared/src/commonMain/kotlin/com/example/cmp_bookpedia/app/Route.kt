package com.example.cmp_bookpedia.app

import kotlinx.serialization.Serializable

sealed interface Route {

    // Graph: set of multiple screens of same feature
    @Serializable
    data object BookGraph: Route

    @Serializable
    data object BookList: Route
    @Serializable
    data class BookDetail(val id: String): Route
}
