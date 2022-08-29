package com.example.feature_main_screen.presentation.common.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.common.resource_manager.ResourceManager
import com.example.feature_main_screen.domain.usecase.GetDataMainScreenUseCase
import com.example.feature_main_screen.presentation.screens.products.ProductsViewModel
import javax.inject.Inject

internal class ViewModelFactory @Inject constructor(
    private val getDataMainScreenUseCase: GetDataMainScreenUseCase,
    private val resourceManager: ResourceManager
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
         ProductsViewModel(getDataMainScreenUseCase, resourceManager) as T

}