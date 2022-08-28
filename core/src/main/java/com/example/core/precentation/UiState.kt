package com.example.core.precentation

sealed class UiState<out T> {

    class Loading<T> : UiState<T>()

    class Error<T>(val error: Throwable) : UiState<T>()

    class Success<T>(val data: T) : UiState<T>()

}


inline fun <T> UiState<T>.onSuccess(block: (T) -> Unit) : UiState<T> {
    if (this is UiState.Success) {
        block(this.data)
    }
      return  this
}

inline fun <T> UiState<T>.onError(block: (Throwable) -> Unit) : UiState<T> {
    if (this is UiState.Error) {
        block(this.error)
    }
    return  this
}
