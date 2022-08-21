package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainScreenAdapter(
    onProductClick:(DisplayableItem) -> Unit,
): AsyncListDifferDelegationAdapter<DisplayableItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(MainScreenDelegates.bestSellerCardsAdapterDelegate(onProductClick))
            .addDelegate(MainScreenDelegates.hotSaleSHorizontalAdapterDelegate())
    }
}