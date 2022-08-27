package com.example.common_tab_bar.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common_tab_bar.domain.usecase.GetCountCartItemUseCase
import com.example.common_tab_bar.presentation.screens.tabbar.TabBarViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val useCase: GetCountCartItemUseCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        TabBarViewModel(useCase) as T
}