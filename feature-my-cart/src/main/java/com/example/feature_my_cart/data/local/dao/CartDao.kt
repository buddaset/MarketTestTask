package com.example.feature_my_cart.data.local.dao

import androidx.room.*
import com.example.feature_my_cart.data.local.model.BasketEntity
import com.example.feature_my_cart.data.local.model.CartEntity
import com.example.feature_my_cart.data.local.model.CartWithBasketTuple
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao {


    @Transaction
    @Query("SELECT * FROM cards WHERE id = :cartId")
    fun getCartWithBasket(cartId: String = TEST_CART_ID ): Flow<CartWithBasketTuple>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: CartEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBaskets(list: List<BasketEntity>)

    @Transaction
    suspend fun insertData(cart: CartEntity) {
        insertCart(cart)
        insertBaskets(cart.basket)
    }


    companion object {
        private const val TEST_CART_ID = "4"
    }
}