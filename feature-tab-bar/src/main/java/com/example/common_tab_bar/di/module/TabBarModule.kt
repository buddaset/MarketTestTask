package com.example.common_tab_bar.di.module

import com.example.common_tab_bar.data.remote.api.CountCartApi
import com.example.common_tab_bar.data.repository.CartItemRepositoryImpl
import com.example.common_tab_bar.domain.repository.CartItemRepository
import com.example.core.di.scope.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal interface TabBarModule {

    @Binds
    @FeatureScope
    fun bindCartItemRepository(impl: CartItemRepositoryImpl) : CartItemRepository


    companion object {
        @Provides
        fun provideCountCartApi(retrofit: Retrofit) : CountCartApi =
            retrofit.create(CountCartApi::class.java)
    }


}