package com.example.feature_map_location.presentation.common.model

import com.example.feature_map_location.R

data class Marker(
    val latitude: Double,
    val longitude: Double,
    val iconId: Int = R.drawable.test_pin
)
