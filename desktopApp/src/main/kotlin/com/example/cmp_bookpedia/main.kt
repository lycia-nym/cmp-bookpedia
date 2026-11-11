    package com.example.cmp_bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.cmp_bookpedia.app.App
import com.example.cmp_bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}