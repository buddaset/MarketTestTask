package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.core_ui.R.drawable.ic_favorite_on
import com.example.feature_main_screen.databinding.BestSellerHorizontalItemBinding
import com.example.feature_main_screen.databinding.BestSellerItemBinding
import com.example.feature_main_screen.databinding.HotSalesHorizontalItemBinding
import com.example.feature_main_screen.databinding.HotSalesItemBinding
import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.domain.model.HotSales
import com.example.feature_main_screen.presentation.screens.ListBestSeller
import com.example.feature_main_screen.presentation.screens.ListHotSales
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


object MainScreenDelegates {


    fun bestSellerCardsAdapterDelegate(
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


    fun hotSaleSHorizontalAdapterDelegate() =
        adapterDelegateViewBinding<ListHotSales, DisplayableItem, HotSalesHorizontalItemBinding>(
            { layoutInflater, parent ->
                HotSalesHorizontalItemBinding.inflate(layoutInflater, parent, false)
            }) {

            val adapter = ListDelegationAdapter(hotSalesAdapterDelegate())

            binding.hotSalesRecyclerView.adapter = adapter

            bind {
                adapter.items = item.hotSales
            }

        }


    fun hotSalesAdapterDelegate() =
        adapterDelegateViewBinding<HotSales, DisplayableItem, HotSalesItemBinding>(
            { layoutInflater, parent -> HotSalesItemBinding.inflate(layoutInflater, parent, false) }
        ) {
            bind {
                binding.newProductGroup.isVisible = item.isNew
                binding.nameProduct.text = item.title
                binding.briefDescriptionProduct.text = item.subtitle
                Glide.with(itemView)
                    .load(item.picture)
                    .into(binding.imageProduct)
            }
        }


    fun bestSellerAdapterDelegate(
        onProductClick: (DisplayableItem) -> Unit
    ) =
        adapterDelegateViewBinding<BestSeller, DisplayableItem, BestSellerItemBinding>(
            { inflater, parent -> BestSellerItemBinding.inflate(inflater, parent, false) }
        ) {

            bind {

                if (item.isFavorites) binding.isFavoriteProduct.setImageResource(ic_favorite_on)
                binding.priceDiscount.text = item.discountPrice.toString()
                binding.priceFull.text = item.priceWithoutDiscount.toString()
                binding.titleProduct.text = item.title
                Glide.with(itemView)
                    .load(item.picture)
                    .into(binding.productImage)

                binding.root.setOnClickListener { onProductClick(item) }
            }
        }


}
















































