package com.example.feature_my_cart.data.remote.api

import com.example.feature_my_cart.data.remote.model.CartDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

internal interface CartApi {

    @GET(CART_PATH)
    fun loadMyCart() : Flow<CartDto>


    companion object {

     private  const val CART_PATH ="53539a72-3c5f-4f30-bbb1-6ca10d42c149"
    }
}