package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.feature_main_screen.databinding.HotSalesItemBinding
import com.example.feature_main_screen.domain.model.HotSales
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class HotSalesProductCardsAdapter: AsyncListDifferDelegationAdapter<DisplayableItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager
            .addDelegate(hotSalesAdapterDelegate())
    }


   private fun hotSalesAdapterDelegate() =
        adapterDelegateViewBinding<HotSales, DisplayableItem, HotSalesItemBinding>(
            { layoutInflater, parent -> HotSalesItemBinding.inflate(layoutInflater, parent, false) }
        ) {
            bind {
                binding.newProductGroup.isVisible = item.isNew
                binding.nameProduct.text = item.title
                binding.briefDescriptionProduct.text = item.subtitle
                Glide.with(itemView)
                    .load(item.picture)
                    .transition( withCrossFade())
                    .into(binding.imageProduct)
            }
        }

}