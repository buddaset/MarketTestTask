package com.example.core.common.resource_manager

import android.content.Context
import androidx.annotation.StringRes

class ResourceManagerImpl (private val context: Context) : ResourceManager {

    override fun getString(@StringRes resId: Int): String =
        context.getString(resId)


}