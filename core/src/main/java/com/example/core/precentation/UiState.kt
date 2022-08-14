package com.example.core.precentation

sealed class UiState<out T> {

    class Loading<T> : UiState<T>()

    class Error<T>(val error: Throwable) : UiState<T>()

    class Success<T>(val data: T) : UiState<T>()

}