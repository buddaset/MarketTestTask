package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import android.graphics.Paint
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.core_ui.R
import com.example.feature_main_screen.databinding.BestSellerItemBinding
import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.presentation.model.BestSellerUi
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class BestSellerProductCardsAdapter(
    onProductClick: (ItemUi) -> Unit
) : AsyncListDifferDelegationAdapter<ItemUi>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(bestSellerAdapterDelegate(onProductClick))
    }

    private fun bestSellerAdapterDelegate(
        onProductClick: (ItemUi) -> Unit
    ) =
        adapterDelegateViewBinding<BestSellerUi, ItemUi, BestSellerItemBinding>(
            { inflater, parent -> BestSellerItemBinding.inflate(inflater, parent, false) }
        ) {

            bind {
                val isFavoriteRes = if (item.isFavorites) R.drawable.ic_favorite_on
                else R.drawable.ic_favorite_off
                binding.isFavoriteProduct.setImageResource(isFavoriteRes)
                binding.priceDiscount.text = item.discountPrice
                binding.priceFull.apply {
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    text = item.priceWithoutDiscount
                }
                binding.titleProduct.text = item.title
                Glide.with(itemView)
                    .load(item.picture)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.productImage)

                binding.root.setOnClickListener { onProductClick(item) }
            }
        }

    override fun getItemId(position: Int): Long {
        return items[position].itemId
    }
}