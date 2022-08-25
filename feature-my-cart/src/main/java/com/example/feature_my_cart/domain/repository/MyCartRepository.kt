package com.example.feature_my_cart.domain.repository

import com.example.feature_my_cart.domain.model.Cart
import kotlinx.coroutines.flow.Flow

interface MyCartRepository {


   fun  getMyCart(): Flow<Cart>
}