package com.example.feature_main_screen.domain.model

import com.example.feature_main_screen.data.remote.model.BestSellerDto
import com.example.feature_main_screen.data.remote.model.HomeStoreDto
import kotlinx.serialization.SerialName

data class MainScreenData (
    val bestSeller: List<BestSeller>,
    val homeStore: List<HomeStore>
    )
