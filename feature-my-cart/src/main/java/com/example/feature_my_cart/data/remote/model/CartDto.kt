package com.example.feature_my_cart.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartDto(
    @SerialName("basket") val basket: List<BasketDto>,
    @SerialName("delivery") val delivery: String,
    @SerialName("id") val id: String,
    @SerialName("total") val total: Int
)