package com.example.feature_product_details.presentation.common.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.feature_product_details.domain.usecase.GetProductDetailsUseCase
import com.example.feature_product_details.presentation.screens.product_details.ProductDetailsViewModel
import javax.inject.Inject

internal class ViewModelFactory @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
         ProductDetailsViewModel(getProductDetailsUseCase) as T

}