package com.example.feature_main_screen.presentation.model

import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi


internal data class HotSalesUi(
    val id: Int,
    val isBuy: Boolean,
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
) : ItemUi {
    override val itemId: Long = id.toLong()
}
