package com.example.cmp_bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.example.cmp_bookpedia.app.App
import com.example.cmp_bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}
