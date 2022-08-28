package com.example.core.precentation.extension

import com.google.android.material.tabs.TabLayout


fun TabLayout.onTabSelectedListener(onSelected : (TabLayout.Tab) -> Unit) =
    object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.let { onSelected(it) }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}


    }