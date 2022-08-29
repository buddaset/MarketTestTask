package com.example.common_tab_bar.presentation.screens.tabbar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_tab_bar.domain.model.CountCartItem
import com.example.common_tab_bar.domain.usecase.GetCountCartItemUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class TabBarViewModel @Inject constructor(
     getCountCartItemUseCase: GetCountCartItemUseCase
) : ViewModel() {


    val countCartItem: StateFlow<CountCartItem> =
        getCountCartItemUseCase()
            .catch {  CountCartItem(count = 0)}
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = CountCartItem(count = 0)
            )
}