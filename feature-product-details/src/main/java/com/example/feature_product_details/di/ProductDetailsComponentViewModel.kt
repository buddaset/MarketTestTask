package com.example.feature_product_details.di

import androidx.lifecycle.ViewModel
import com.example.feature_product_details.di.component.DaggerProductDetailsComponent
import com.example.feature_product_details.di.dependency.ProductDetailsDependencies
import kotlin.properties.Delegates

internal class ProductDetailsComponentViewModel : ViewModel() {

    val productDetailsComponent =
        DaggerProductDetailsComponent.factory().create(ProductDetailsDependenciesProvider.dependencies)
}

internal interface ProductDetailsDependenciesProvider {

    val dependencies: ProductDetailsDependencies

    companion object : ProductDetailsDependenciesProvider by ProductDetailsDependenciesStore
}

object ProductDetailsDependenciesStore: ProductDetailsDependenciesProvider {

    override var dependencies: ProductDetailsDependencies by Delegates.notNull()

}