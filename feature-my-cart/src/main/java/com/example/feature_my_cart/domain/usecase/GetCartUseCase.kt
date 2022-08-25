package com.example.feature_my_cart.domain.usecase

import com.example.feature_my_cart.domain.model.Cart
import com.example.feature_my_cart.domain.repository.MyCartRepository
import kotlinx.coroutines.flow.Flow

class GetCartUseCase(private val repository: MyCartRepository) {

    operator fun  invoke(): Flow<Cart> =
        repository.getCart()
}