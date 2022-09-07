package com.example.common_tab_bar.data.repository

import com.example.common_tab_bar.data.local.TabBarDao
import com.example.common_tab_bar.data.remote.api.CountCartApi
import com.example.common_tab_bar.domain.model.CountCartItem
import com.example.common_tab_bar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

internal class CartItemRepositoryImpl @Inject constructor(
    private val countCartApi: CountCartApi,
private val tabBarDao: TabBarDao) : CartItemRepository {
    override fun getCountItem(): Flow<CountCartItem> =
        tabBarDao.getCountItem()
            .transform {  data -> emit(checkEmptyLocalData(data)) }


    private suspend fun checkEmptyLocalData(data: Int?): CountCartItem =
        data?.let { CountCartItem(count = it) } ?: loadCart()

    private suspend fun loadCart() : CountCartItem =
        countCartApi.loadCart()
            .map { cartResponse -> CountCartItem(count = cartResponse.items.size) }
            .first()

}