package com.example.feature_my_cart.presentation.common.model

internal data class BasketUi(
    val id: Int,
    val images: String,
    val price: String,
    val title: String,
    val count: Int = DEFAULT_COUNT

) {

    companion object {

        const val DEFAULT_COUNT = 1
    }
}