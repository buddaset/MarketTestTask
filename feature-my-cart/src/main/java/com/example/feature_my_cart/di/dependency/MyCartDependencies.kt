package com.example.feature_my_cart.di.dependency

import com.example.core.common.dispatcher.Dispatcher
import retrofit2.Retrofit

interface MyCartDependencies {

    val retrofit: Retrofit
    val dispatcher: Dispatcher
}