package com.example.feature_main_screen.presentation.adapters.delegateAdapter

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<DisplayableItem>() {
    override fun areItemsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean =
        oldItem.itemId == newItem.itemId



    override fun areContentsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean  =
        oldItem.equals(newItem)

}