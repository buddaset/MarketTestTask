package com.example.markettesttask.di.module

import android.content.Context
import com.example.core.di.scope.ApplicationScope
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


    }
}