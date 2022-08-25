package com.example.feature_my_cart.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_my_cart.domain.usecase.GetMyCartUseCase
import com.example.feature_my_cart.presentation.screens.mycart.MyCartViewModel

class ViewModelFactory(
    private val getMyCartUseCase: GetMyCartUseCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MyCartViewModel(getMyCartUseCase) as T
    }
