package com.example.cmp_bookpedia.di

import com.example.cmp_bookpedia.book.data.network.KtorRemoteBookDatasource
import com.example.cmp_bookpedia.book.data.network.RemoteBookDatasource
import com.example.cmp_bookpedia.book.data.repository.DefaultBookRepository
import com.example.cmp_bookpedia.book.domain.BookRepository
import com.example.cmp_bookpedia.book.presentation.book_list.BookListViewModel
import com.example.cmp_bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    // single vs singleOf
    // single: manually add get() when there's new dependency
    // singleOf: auto find all dependency needed
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDatasource).bind<RemoteBookDatasource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
}