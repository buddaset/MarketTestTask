package com.example.core.precentation

sealed class UiState<out T> {

    object Loading : UiState<Nothing>()

    class Error(val error: Throwable) : UiState<Nothing>()

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
