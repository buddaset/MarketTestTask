package com.example.core.common.navigation

import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController




fun Fragment.navigate(actionId: Int, hostId: Int? = null, data: Bundle? = null) {
    if (hostId != null) {
        Navigation.findNavController(requireActivity(), hostId).navigate(actionId, data)
        return
    }

    val navController = findNavController()
    val currentDestination =
        (navController.currentDestination as? FragmentNavigator.Destination)?.className
            ?: (navController.currentDestination as? DialogFragmentNavigator.Destination)?.className

    if (currentDestination == this.javaClass.name)
        navController.navigate(actionId, data)
}

