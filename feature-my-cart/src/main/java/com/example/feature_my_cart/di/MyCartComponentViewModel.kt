package com.example.feature_my_cart.di

import androidx.lifecycle.ViewModel
import com.example.feature_my_cart.di.component.MyCartComponent
import com.example.feature_my_cart.di.dependency.MyCartDependencies
import com.example.feature_my_cart.di.component.DaggerMyCartComponent
import kotlin.properties.Delegates

internal class MyCartComponentViewModel: ViewModel() {

    val myCartComponent =
        DaggerMyCartComponent.factory().create(MyCartDependenciesProvider.dependencies)
}

internal interface MyCartDependenciesProvider {

    val dependencies: MyCartDependencies

    companion object : MyCartDependenciesProvider by MyCartDependenciesStore


}

object MyCartDependenciesStore : MyCartDependenciesProvider {
    override var dependencies: MyCartDependencies by Delegates.notNull()
}