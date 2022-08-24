package com.example.feature_product_details.di.component

import com.example.core.di.scope.FeatureScope
import com.example.feature_product_details.di.dependency.ProductDetailsDependencies
import com.example.feature_product_details.di.module.ProductDetailsModule
import com.example.feature_product_details.presentation.screens.product_details.ProductDetailsFragment
import com.example.feature_product_details.presentation.screens.shop.ShopSectionFragment
import dagger.Component


@FeatureScope
@Component(dependencies = [ProductDetailsDependencies::class] , modules = [ProductDetailsModule::class])
internal interface ProductDetailsComponent {

    fun inject(fragment: ProductDetailsFragment)
    fun inject(fragment: ShopSectionFragment)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: ProductDetailsDependencies
        ): ProductDetailsComponent
    }
}