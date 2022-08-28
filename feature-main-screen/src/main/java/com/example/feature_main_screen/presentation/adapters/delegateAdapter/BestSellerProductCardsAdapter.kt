package com.example.feature_main_screen.presentation.adapters.delegateAdapter

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
) : AsyncListDifferDelegationAdapter<ItemUi>(BaseDiffUtilItemCallback())  {

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

                if (item.isFavorites) binding.isFavoriteProduct.setImageResource(R.drawable.ic_favorite_on)
                binding.priceDiscount.text = item.discountPrice.toString()
                binding.priceFull.text = item.priceWithoutDiscount.toString()
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