package com.example.feature_my_cart.domain.repository

import com.example.feature_my_cart.domain.model.Cart
import kotlinx.coroutines.flow.Flow

internal interface MyCartRepository {


   fun  getMyCart(): Flow<Cart>
}