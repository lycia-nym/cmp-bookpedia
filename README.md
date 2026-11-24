# BookPedia

A cross-platform book discovery application built with **Kotlin Multiplatform** and **Compose Multiplatform**.

BookPedia is a multiplatform project designed to provide a shared application experience across Android, iOS, and Desktop using a common Kotlin codebase.

## Features

- Cross-platform application targeting Android, iOS, and Desktop
- Shared UI and application logic using Compose Multiplatform
- HTTP networking using Ktor Client
- Dependency injection using Koin
- Local data persistence using Room
- Image loading using Coil
- Screen navigation using Compose Navigation

## Tech Stack

- **Kotlin**
- **Kotlin Multiplatform (KMP)**
- **Compose Multiplatform (CMP)**
- **Material 3**
- **Ktor Client** — networking and API requests
- **Koin** — dependency injection
- **Kotlin Serialization** — JSON serialization
- **Coil** — image loading
- **Room** — local database
- **Coroutines** — asynchronous operations
- **Compose Navigation** — navigation between screens

## Architecture

The project separates platform-specific implementations from shared application code:

- **Shared** — common application logic, UI, networking, and data management
- **Android** — Android-specific implementations and platform configuration
- **iOS** — iOS application entry point and platform-specific integration
- **Desktop** — JVM-specific implementations and desktop application configuration

The shared module uses dependency injection to manage application dependencies and platform-specific implementations to support networking across different targets.

## Purpose

This project was created while following **Philipp Lackner's BookPedia Kotlin Multiplatform course** as hands-on practice with modern Kotlin Multiplatform development, Compose Multiplatform, and building cross-platform applications using a shared Kotlin codebase.
