package com.example.feature_product_details.presentation.screens.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.precentation.UiState
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.usecase.GetProductDetailsUseCase
import com.example.feature_product_details.presentation.common.mapper.toUi
import com.example.feature_product_details.presentation.common.model.ProductDetailsUi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class ProductDetailsViewModel @Inject constructor(
      getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {


    @OptIn(ExperimentalCoroutinesApi::class)
    val data: StateFlow<UiState<ProductDetailsUi>> =
        getProductDetailsUseCase()
            .mapLatest { productDetails -> handleSuccess(productDetails) }
            .catch { error -> emit(UiState.Error(error = error)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UiState.Loading
            )


    private fun handleSuccess(productDetails: ProductDetails) : UiState<ProductDetailsUi> =
        UiState.Success(data =productDetails.toUi())



}