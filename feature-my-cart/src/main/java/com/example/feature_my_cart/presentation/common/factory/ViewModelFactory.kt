package com.example.feature_my_cart.presentation.common.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_my_cart.domain.usecase.GetMyCartUseCase
import com.example.feature_my_cart.presentation.screens.mycart.MyCartViewModel
import javax.inject.Inject

internal class ViewModelFactory @Inject constructor(
    private val getMyCartUseCase: GetMyCartUseCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MyCartViewModel(getMyCartUseCase) as T
    }
