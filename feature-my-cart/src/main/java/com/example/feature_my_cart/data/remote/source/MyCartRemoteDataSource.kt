package com.example.feature_my_cart.data.remote.source

import com.example.feature_my_cart.data.remote.model.CartDto
import kotlinx.coroutines.flow.Flow

internal interface MyCartRemoteDataSource {

    fun loadMyCart(): Flow<CartDto>
}