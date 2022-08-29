package com.example.feature_my_cart.domain.model

internal data class Basket(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String
)