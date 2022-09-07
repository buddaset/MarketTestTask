package com.example.feature_product_details.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDetailsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: ProductDetailsEntity)


    @Query("SELECT * FROM product_details WHERE id = :id")
    fun getProductDetails(id: String = TEST_ID ): Flow<ProductDetailsEntity>


    companion object {

        private const val TEST_ID = "3"
    }
}