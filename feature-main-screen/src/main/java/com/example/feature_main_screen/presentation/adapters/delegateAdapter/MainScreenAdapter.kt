package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import androidx.recyclerview.widget.PagerSnapHelper
import com.example.feature_main_screen.databinding.BestSellerHorizontalItemBinding
import com.example.feature_main_screen.databinding.HotSalesHorizontalItemBinding
import com.example.feature_main_screen.presentation.screens.ListBestSeller
import com.example.feature_main_screen.presentation.screens.ListHotSales
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class MainScreenAdapter(
    onProductClick: (DisplayableItem) -> Unit,
) : AsyncListDifferDelegationAdapter<DisplayableItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(bestSellerCardsAdapterDelegate(onProductClick))
            .addDelegate(hotSaleSCardsAdapterDelegate())
    }

    private fun bestSellerCardsAdapterDelegate(
        onProductClick: (DisplayableItem) -> Unit
    ) =
        adapterDelegateViewBinding<ListBestSeller, DisplayableItem, BestSellerHorizontalItemBinding>(
            { layoutInflater, parent ->
                BestSellerHorizontalItemBinding.inflate(layoutInflater, parent, false)
            }
        ) {
            val adapter = BestSellerProductCardsAdapter(onProductClick)
            binding.bestSellerRecyclerView.adapter = adapter

            bind {
                adapter.items = item.bestSellers

            }
        }


    private fun hotSaleSCardsAdapterDelegate() =
        adapterDelegateViewBinding<ListHotSales, DisplayableItem, HotSalesHorizontalItemBinding>(
            { layoutInflater, parent ->
                HotSalesHorizontalItemBinding.inflate(layoutInflater, parent, false)
            }) {
            val adapter = HotSalesProductCardsAdapter()

            binding.hotSalesRecyclerView.adapter = adapter
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(binding.hotSalesRecyclerView)

            bind {
                adapter.items = item.hotSales
            }

        }
}