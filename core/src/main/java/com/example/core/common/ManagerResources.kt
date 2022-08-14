package com.example.core.common

import androidx.annotation.StringRes

interface ManagerResources {

    fun string(@StringRes resId: Int): String
}