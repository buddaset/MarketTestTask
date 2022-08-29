package com.example.feature_my_cart.presentation.adapters.cart_adapter

import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.feature_my_cart.databinding.MyCartItemBinding
import com.example.feature_my_cart.domain.model.Basket
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

internal class MyCartAdapter : AsyncListDifferDelegationAdapter<Basket>(DIFF_UTIL_CALLBACK) {


    init {
        delegatesManager
            .addDelegate(myCartAdapterDelegate())
    }


    private fun myCartAdapterDelegate() =
        adapterDelegateViewBinding<Basket, Basket, MyCartItemBinding>(
            { inflater, parent -> MyCartItemBinding.inflate(inflater, parent, false) }
        ) {
            bind {
                binding.nameItemTextView.text = item.title
                binding.priceItemTextView.text = item.price.toString()
                binding.itemCountTextView.text = "1"
                Glide.with(itemView)
                    .load(item.images)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.cartItemImageView)
            }
        }


    companion object {
        private val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Basket>() {
            override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean =
                oldItem == newItem


        }
    }
}