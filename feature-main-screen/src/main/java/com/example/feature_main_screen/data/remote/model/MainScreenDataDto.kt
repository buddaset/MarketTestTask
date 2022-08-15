package com.example.feature_main_screen.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MainScreenDataDto(
    @SerialName("best_seller") val bestSeller: List<BestSellerDto>,
    @SerialName("home_store") val homeStore: List<HomeStoreDto>
)