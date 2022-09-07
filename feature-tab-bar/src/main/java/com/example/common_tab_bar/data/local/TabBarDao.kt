package com.example.common_tab_bar.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TabBarDao {


    @Query("SELECT count(*) FROM carts_baskets_cross_ref WHERE cart_id = :cartId")
    fun getCountItem(cartId: String = TEST_ID_CART): Flow<Int>



    companion object {

        private const val TEST_ID_CART = "4"
    }
}