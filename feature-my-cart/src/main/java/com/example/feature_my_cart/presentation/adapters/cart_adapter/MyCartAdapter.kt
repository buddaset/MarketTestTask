package com.example.feature_my_cart.presentation.adapters.cart_adapter

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.feature_my_cart.R
import com.example.feature_my_cart.databinding.MyCartItemBinding
import com.example.feature_my_cart.domain.model.Basket
import com.example.feature_my_cart.presentation.common.model.BasketUi
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

internal class MyCartAdapter : AsyncListDifferDelegationAdapter<BasketUi>(DIFF_UTIL_CALLBACK) {


    init {
        delegatesManager
            .addDelegate(myCartAdapterDelegate())
    }


    private fun myCartAdapterDelegate() =
        adapterDelegateViewBinding<BasketUi, BasketUi, MyCartItemBinding>(
            { inflater, parent -> MyCartItemBinding.inflate(inflater, parent, false) }
        ) {
            bind {
                val context = itemView.context
                binding.nameItemTextView.text = item.title
                binding.priceItemTextView.text = itemView.context.getString(R.string.price, item.price)
                binding.itemCountTextView.text = item.count.toString()
                Glide.with(itemView)
                    .load(item.images)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.cartItemImageView)
            }
        }


    companion object {
        private val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<BasketUi>() {
            override fun areItemsTheSame(oldItem: BasketUi, newItem: BasketUi): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: BasketUi, newItem: BasketUi): Boolean =
                oldItem == newItem


        }
    }
}