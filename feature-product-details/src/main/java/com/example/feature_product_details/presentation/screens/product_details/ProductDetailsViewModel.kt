package com.example.feature_product_details.presentation.screens.product_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.precentation.UiState
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.usecase.GetProductDetailsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    private val  getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {


    @OptIn(ExperimentalCoroutinesApi::class)
    val data: StateFlow<UiState<ProductDetails>> =
        getProductDetailsUseCase()
            .catch { error -> UiState.Error<ProductDetails>(error = error) }
            .mapLatest { data -> UiState.Success(data = data) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UiState.Loading()
            )



}