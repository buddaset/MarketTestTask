package com.example.core.common.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


fun Fragment.navigate(actionId: Int, hostId: Int? = null , data: Bundle? = null) {
    val navController = if (hostId == null ) this.findNavController()
    else Navigation.findNavController(requireActivity(), hostId)

    navController.navigate(actionId, data)
}