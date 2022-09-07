package com.example.markettesttask.di.module

import android.content.Context
import com.example.core.di.scope.ApplicationScope
import com.example.feature_main_screen.data.local.dao.MainScreenDataDao
import com.example.feature_my_cart.data.local.dao.CartDao
import com.example.feature_product_details.data.local.dao.ProductDetailsDao
import com.example.markettesttask.db.MarketDatabase

import dagger.Module
import dagger.Provides

@Module
interface DatabaseModule {




    companion object {

        @Provides
        @ApplicationScope
        fun provideMarketDatabase(context: Context): MarketDatabase =
            MarketDatabase.getInstance(context)



        @Provides
        fun provideMainScreenDataDao(db: MarketDatabase): MainScreenDataDao =
            db.mainScreenDataDao()


        @Provides
        fun provideProductDetailsDao(db: MarketDatabase): ProductDetailsDao =
            db.productDetailsDao()

        @Provides
        fun provideCartDao(db: MarketDatabase): CartDao =
            db.cartDao()

    }
}