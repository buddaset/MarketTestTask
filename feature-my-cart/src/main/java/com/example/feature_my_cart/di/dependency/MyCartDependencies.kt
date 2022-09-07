package com.example.feature_my_cart.di.dependency

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_my_cart.data.local.dao.CartDao
import retrofit2.Retrofit

interface MyCartDependencies {

    val retrofit: Retrofit
    val dispatcher: Dispatcher
    val cartDao : CartDao
}