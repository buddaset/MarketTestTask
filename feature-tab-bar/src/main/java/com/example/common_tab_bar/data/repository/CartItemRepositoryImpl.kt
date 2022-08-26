package com.example.common_tab_bar.data.repository

import com.example.common_tab_bar.data.remote.api.CountCartApi
import com.example.common_tab_bar.domain.model.CountCartItem
import com.example.common_tab_bar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartItemRepositoryImpl(
    private val countCartApi: CountCartApi) : CartItemRepository {
    override fun getCountItem(): Flow<CountCartItem> =
        countCartApi.loadCart()
            .map { cartResponse -> CountCartItem(count = cartResponse.items.size) }

}