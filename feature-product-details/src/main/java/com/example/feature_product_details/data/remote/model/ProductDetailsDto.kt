package com.example.feature_product_details.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class ProductDetailsDto(
    @SerialName("CPU") val CPU: String,
    @SerialName("camera") val camera: String,
    @SerialName("capacity") val capacity: List<String>,
    @SerialName("color") val color: List<String>,
    @SerialName("id") val id: String,
    @SerialName("images") val images: List<String>,
    @SerialName("isFavorites") val isFavorites: Boolean,
    @SerialName("price") val price: Int,
    @SerialName("rating") val rating: Double,
    @SerialName("sd") val sd: String,
    @SerialName("ssd") val ssd: String,
    @SerialName("title") val title: String
)