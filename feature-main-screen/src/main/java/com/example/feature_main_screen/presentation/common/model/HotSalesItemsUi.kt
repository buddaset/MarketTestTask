package com.example.feature_main_screen.presentation.common.model

import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi


internal data class HotSalesItemsUi(
    val title: String = "Hot Sales",
    val hotSales: List<HotSalesUi>
) : ItemUi {
    override val itemId: Long = title.hashCode().toLong()
}
