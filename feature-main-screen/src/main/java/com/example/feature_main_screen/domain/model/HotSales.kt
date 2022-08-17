package com.example.feature_main_screen.domain.model

 internal data class HotSales(
    val id: Int,
    val isBuy: Boolean,
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)
