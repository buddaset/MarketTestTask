package com.example.feature_my_cart.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BasketDto(
    @SerialName("id") val id: Int,
    @SerialName("images") val images: String,
    @SerialName("price") val price: Int,
    @SerialName("title") val title: String
)