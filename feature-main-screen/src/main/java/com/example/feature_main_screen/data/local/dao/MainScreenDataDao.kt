package com.example.feature_main_screen.data.local.dao

import androidx.room.*
import com.example.feature_main_screen.data.local.model.BestSellerEntity
import com.example.feature_main_screen.data.local.model.HotSalesEntity
import com.example.feature_main_screen.data.local.model.MainScreenDataEntityContainer


@Dao
interface MainScreenDataDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBestSellersProducts(list: List<BestSellerEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotSalesProducts(list: List<HotSalesEntity>)

    @Query("SELECT * FROM best_seller_products")
    suspend fun getBestSellersProducts(): List<BestSellerEntity>

    @Query("SELECT * FROM hot_sales_products")
    suspend fun getHotSalesProducts(): List<HotSalesEntity>

    @Transaction
    suspend fun getData(): MainScreenDataEntityContainer =
        MainScreenDataEntityContainer(
            bestSeller = getBestSellersProducts(),
            hotSales = getHotSalesProducts()
        )


    @Transaction
    suspend fun insertData(data: MainScreenDataEntityContainer) {
        insertBestSellersProducts(data.bestSeller)
        insertHotSalesProducts(data.hotSales)
    }


}