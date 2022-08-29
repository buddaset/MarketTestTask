package com.example.core.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherMainUI (
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val main:  CoroutineDispatcher = Dispatchers.Main ) : Dispatcher