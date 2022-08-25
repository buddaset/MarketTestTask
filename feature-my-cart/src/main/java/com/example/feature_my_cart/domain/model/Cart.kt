package com.example.feature_my_cart.domain.model

import com.example.feature_my_cart.domain.model.Basket

data class Cart(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)