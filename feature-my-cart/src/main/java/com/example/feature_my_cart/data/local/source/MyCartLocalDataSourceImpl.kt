package com.example.feature_my_cart.data.local.source

import com.example.feature_my_cart.data.local.dao.CartDao
import com.example.feature_my_cart.data.local.model.CartEntity
import com.example.feature_my_cart.data.local.model.CartWithBasketTuple
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


internal class MyCartLocalDataSourceImpl  @Inject constructor(
    private val cartDao: CartDao
) : MyCartLocalDataSource {


    override suspend fun save(cartEntity: CartEntity) {
        cartDao.saveData(cartEntity)
    }

    override fun getMyCart(): Flow<CartWithBasketTuple> =
        cartDao.getCartWithBasket()

}