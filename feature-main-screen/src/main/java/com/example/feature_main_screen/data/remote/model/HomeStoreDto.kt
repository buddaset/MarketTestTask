package com.example.feature_main_screen.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class HomeStoreDto(
    @SerialName("id") val id: Int,
    @SerialName("is_buy") val isBuy: Boolean = false,
    @SerialName("is_new") val isNew: Boolean = false,
    @SerialName("picture") val picture: String,
    @SerialName("subtitle") val subtitle: String,
    @SerialName("title") val title: String
)