package com.example.cmp_bookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform