package com.example.cmp_bookpedia.core.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.sse.SSEBufferPolicy
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.logger.Level
import org.koin.core.logger.MESSAGE

object HttpClientFactory {

    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            // install needed feature from Ktor
            // parse json data to app data
            install(ContentNegotiation) {
                json(
                    json = Json {
                        // prevent app crash from unknown keys
                        ignoreUnknownKeys = true
                    }
                )
            }
            // set request timed out
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }
            // logging for debug
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
                level = LogLevel
            }
            // default configure for every requests
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }
}