package com.example.feature_main_screen.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_main_screen.domain.usecase.GetDataMainScreenUseCase
import com.example.feature_main_screen.presentation.screens.product.ProductsViewModel
import javax.inject.Inject

internal class ViewModelFactory @Inject constructor(
    private val getDataMainScreenUseCase: GetDataMainScreenUseCase
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
         ProductsViewModel(getDataMainScreenUseCase) as T

}