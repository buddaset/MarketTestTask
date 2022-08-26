package com.example.common_tab_bar.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartItemDto(
   @SerialName("id") val id: Int

)
