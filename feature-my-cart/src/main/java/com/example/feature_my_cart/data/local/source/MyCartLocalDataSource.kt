package com.example.feature_my_cart.data.local.source

import com.example.feature_my_cart.data.local.model.CartEntity
import com.example.feature_my_cart.data.local.model.CartWithBasketTuple
import kotlinx.coroutines.flow.Flow


interface MyCartLocalDataSource {


   suspend fun save(cartEntity: CartEntity)


   fun getMyCart(): Flow<CartWithBasketTuple>
}