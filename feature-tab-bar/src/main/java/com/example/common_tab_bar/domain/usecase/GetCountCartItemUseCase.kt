package com.example.common_tab_bar.domain.usecase

import com.example.common_tab_bar.domain.model.CountCartItem
import com.example.common_tab_bar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow

class GetCountCartItemUseCase(
    private val repository: CartItemRepository
) {


    operator fun invoke(): Flow<CountCartItem> =
        repository.getCountItem()
}