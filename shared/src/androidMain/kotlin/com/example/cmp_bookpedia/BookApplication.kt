package com.example.cmp_bookpedia

import android.app.Application
import com.example.cmp_bookpedia.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            module{
                androidContext(this@BookApplication)
            }
        }
    }
}