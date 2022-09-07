package com.example.feature_product_details.di.module

import com.example.core.di.scope.FeatureScope
import com.example.feature_product_details.data.local.source.ProductDetailsLocalDataSource
import com.example.feature_product_details.data.local.source.ProductDetailsLocalDataSourceImpl
import com.example.feature_product_details.data.remote.api.ProductDetailsApi
import com.example.feature_product_details.data.remote.source.ProductDetailsRemoteDataSource
import com.example.feature_product_details.data.remote.source.ProductDetailsRemoteDataSourceImpl
import com.example.feature_product_details.data.repository.ProductDetailRepositoryImpl
import com.example.feature_product_details.domain.repository.ProductDetailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal interface ProductDetailsModule {

    @FeatureScope
    @Binds
    fun bindProductDetailsRepository(impl: ProductDetailRepositoryImpl) : ProductDetailRepository


    @Binds
    fun bindProductDetailsRemoteDataSource(impl: ProductDetailsRemoteDataSourceImpl): ProductDetailsRemoteDataSource


    @Binds
    fun bindProductDetailsLocalDataSource(impl: ProductDetailsLocalDataSourceImpl): ProductDetailsLocalDataSource




    companion object {

        @Provides
        fun provideMainScreenApi(retrofit: Retrofit) : ProductDetailsApi =
            retrofit.create(ProductDetailsApi::class.java)
    }
}