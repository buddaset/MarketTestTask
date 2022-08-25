package com.example.feature_my_cart.data.remote.source

import com.example.feature_my_cart.data.remote.api.CartApi
import com.example.feature_my_cart.data.remote.model.CartDto
import kotlinx.coroutines.flow.Flow

class MyCartRemoteDataSourceImpl(
    private val cartApi: CartApi) : MyCartRemoteDataSource {
    override fun loadMyCart(): Flow<CartDto>  =
        cartApi.loadMyCart()
}