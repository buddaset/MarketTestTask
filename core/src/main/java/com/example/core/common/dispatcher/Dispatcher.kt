package com.example.core.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}

