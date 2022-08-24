package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BestSellerProductCardsAdapter(
    onProductClick: (DisplayableItem) -> Unit
) : AsyncListDifferDelegationAdapter<DisplayableItem>(BaseDiffUtilItemCallback())  {

    init {
        delegatesManager
            .addDelegate(MainScreenDelegates.bestSellerAdapterDelegate(onProductClick))
    }

    override fun getItemId(position: Int): Long {
        return items[position].itemId
    }
}