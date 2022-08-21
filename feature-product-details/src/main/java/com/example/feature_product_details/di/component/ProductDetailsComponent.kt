package com.example.feature_product_details.di.component

import com.example.core.di.scope.FeatureScope
import com.example.feature_product_details.di.dependency.ProductDetailsDependencies
import com.example.feature_product_details.di.module.ProductDetailsModule
import com.example.feature_product_details.presentation.screens.product_details.ProductDetailsFragment
import dagger.Component


@FeatureScope
@Component(dependencies = [ProductDetailsDependencies::class] , modules = [ProductDetailsModule::class])
internal interface ProductDetailsComponent {

    fun inject(fragment: ProductDetailsFragment)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: ProductDetailsDependencies
        ): ProductDetailsComponent
    }
}