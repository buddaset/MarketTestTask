package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import androidx.recyclerview.widget.PagerSnapHelper
import com.example.feature_main_screen.databinding.BestSellerCardsItemBinding
import com.example.feature_main_screen.databinding.HotSalesCardsItemBinding
import com.example.feature_main_screen.presentation.common.model.BestSellerItemsUi
import com.example.feature_main_screen.presentation.common.model.HotSalesItemsUi
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class MainScreenAdapter(
    onProductClick: (ItemUi) -> Unit,
) : AsyncListDifferDelegationAdapter<ItemUi>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(bestSellerCardsAdapterDelegate(onProductClick))
            .addDelegate(hotSaleSCardsAdapterDelegate())
    }

    private fun bestSellerCardsAdapterDelegate(
        onProductClick: (ItemUi) -> Unit
    ) =
        adapterDelegateViewBinding<BestSellerItemsUi, ItemUi, BestSellerCardsItemBinding>(
            { layoutInflater, parent ->
                BestSellerCardsItemBinding.inflate(layoutInflater, parent, false)
            }
        ) {
            val adapter = BestSellerProductCardsAdapter(onProductClick)
            binding.bestSellerRecyclerView.adapter = adapter

            bind {
                adapter.items = item.bestSellers

            }
        }


    private fun hotSaleSCardsAdapterDelegate() =
        adapterDelegateViewBinding<HotSalesItemsUi, ItemUi, HotSalesCardsItemBinding>(
            { layoutInflater, parent ->
                HotSalesCardsItemBinding.inflate(layoutInflater, parent, false)
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