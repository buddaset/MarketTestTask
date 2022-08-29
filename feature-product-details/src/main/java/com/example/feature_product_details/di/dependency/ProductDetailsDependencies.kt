package com.example.feature_product_details.di.dependency

import com.example.core.common.dispatcher.Dispatcher
import retrofit2.Retrofit

interface ProductDetailsDependencies {

    val retrofit: Retrofit
    val dispatcher: Dispatcher
}