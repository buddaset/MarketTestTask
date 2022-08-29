package com.example.common_tab_bar.domain.repository

import com.example.common_tab_bar.domain.model.CountCartItem
import kotlinx.coroutines.flow.Flow

internal interface CartItemRepository {

    fun getCountItem(): Flow<CountCartItem>
}