package com.example.feature_main_screen.presentation.model

import com.example.feature_main_screen.domain.model.HotSales
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi




internal data class HotSalesItemsUi(
    val title: String = "Hot Sales",
    val hotSales: List<HotSales>
) : ItemUi {
    override val itemId: Long = title.hashCode().toLong()
}
