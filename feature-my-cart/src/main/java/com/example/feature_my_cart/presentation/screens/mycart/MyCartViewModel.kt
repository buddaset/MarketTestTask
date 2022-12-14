package com.example.feature_my_cart.presentation.screens.mycart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.precentation.UiState
import com.example.feature_my_cart.domain.model.Cart
import com.example.feature_my_cart.domain.usecase.GetMyCartUseCase
import com.example.feature_my_cart.presentation.common.mapper.toUi
import com.example.feature_my_cart.presentation.common.model.CartUi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

internal class MyCartViewModel(
   getMyCartUseCase: GetMyCartUseCase
) : ViewModel() {


    @OptIn(ExperimentalCoroutinesApi::class)
    val data : StateFlow<UiState<CartUi>> =
        getMyCartUseCase()
            .mapLatest { cart -> handleSuccess(cart) }
            .catch { error -> emit(UiState.Error(error=error))}
            .stateIn(scope =  viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UiState.Loading)


    private fun handleSuccess(cart: Cart) : UiState<CartUi> =
        UiState.Success(data =cart.toUi())

}