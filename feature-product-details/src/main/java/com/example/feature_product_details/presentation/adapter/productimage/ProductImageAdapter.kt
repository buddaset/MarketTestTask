package com.example.feature_product_details.presentation.adapter.productimage

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.feature_product_details.databinding.ImageProductItemBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

internal class ProductImageAdapter : AsyncListDifferDelegationAdapter<String>(DIFF_UTIL_CALLBACK) {

    init {
        delegatesManager
            .addDelegate(imageProductAdapterDelegate())
    }

    private fun imageProductAdapterDelegate() = adapterDelegateViewBinding<String, String, ImageProductItemBinding>(
        {inflater, parent -> ImageProductItemBinding.inflate(inflater, parent, false) }
    ) {
        bind {
            Glide.with(itemView)
                .load(item)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.productImage)
        }
    }

    companion object {
        private val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem
        }
    }
}


