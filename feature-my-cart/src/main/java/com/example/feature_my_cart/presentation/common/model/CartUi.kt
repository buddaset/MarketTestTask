package com.example.feature_my_cart.presentation.common.model



internal data class CartUi(
    val basket: List<BasketUi>,
    val delivery: String,
    val id: String,
    val total: String
)