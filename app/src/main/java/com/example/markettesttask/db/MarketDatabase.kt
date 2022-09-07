package com.example.markettesttask.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.feature_main_screen.data.local.dao.MainScreenDataDao
import com.example.feature_main_screen.data.local.model.BestSellerEntity
import com.example.feature_main_screen.data.local.model.HotSalesEntity
import com.example.feature_my_cart.data.local.dao.CartDao
import com.example.feature_my_cart.data.local.model.BasketEntity
import com.example.feature_my_cart.data.local.model.CartBasketCrossRefEntity
import com.example.feature_my_cart.data.local.model.CartEntity
import com.example.feature_product_details.data.local.converter.ProductDetailsConverter
import com.example.feature_product_details.data.local.dao.ProductDetailsDao
import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import com.example.markettesttask.BuildConfig

@Database(
    entities = [
        HotSalesEntity::class,
        BestSellerEntity::class,
        ProductDetailsEntity::class,
        BasketEntity::class,
        CartBasketCrossRefEntity::class,
        CartEntity::class],

    version = 1
)

@TypeConverters(ProductDetailsConverter::class)
abstract class MarketDatabase : RoomDatabase() {

    abstract fun mainScreenDataDao(): MainScreenDataDao
    abstract fun productDetailsDao(): ProductDetailsDao
    abstract fun cartDao(): CartDao


    companion object {

        @Volatile
        private var INSTANCE: MarketDatabase? = null

        fun getInstance(context: Context): MarketDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        MarketDatabase::class.java,
                        BuildConfig.DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}