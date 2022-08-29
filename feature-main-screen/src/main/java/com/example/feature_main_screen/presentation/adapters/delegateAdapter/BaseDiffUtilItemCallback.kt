package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<ItemUi>() {
    override fun areItemsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean =
        oldItem.itemId == newItem.itemId



    override fun areContentsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean  =
        oldItem.equals(newItem)

}