package com.example.feature_main_screen.presentation.adapters

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.feature_main_screen.databinding.HotSalesItemBinding
import com.example.feature_main_screen.domain.model.HotSales
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

interface ListItem

object MainScreenDelegates {

    internal val hotSalesDelegate = adapterDelegateViewBinding<HotSales, HotSales, HotSalesItemBinding>({
        inflater, container -> HotSalesItemBinding.inflate(inflater, container, false) }
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
}