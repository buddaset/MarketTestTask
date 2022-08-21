package com.example.feature_product_details.presentation.screens.product_details

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.get
import com.example.core.precentation.Extension.collectFlow
import com.example.core.precentation.Extension.showToast
import com.example.core.precentation.UiState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_product_details.di.ProductDetailsComponentViewModel
import com.example.feature_product_details.R
import com.example.feature_product_details.databinding.FragmentProductDetailsBinding
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.presentation.factory.ViewModelFactory
import javax.inject.Inject

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {

    private val binding: FragmentProductDetailsBinding by viewBinding()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ProductDetailsViewModel by viewModels { viewModelFactory }


    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<ProductDetailsComponentViewModel>()
            .productDetailsComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectFlow(viewModel.data, ::handleState)

    }


    private fun handleState(state: UiState<ProductDetails>) {
        Log.d("MainFragment", "state  ---$state")
        when (state) {
            is UiState.Loading -> {}
            is UiState.Success -> {

                Log.d("MainFragment", "hotSales ---${state.data}")
                binding.textView.text = "${state.data}"


            }
            is UiState.Error -> {
                showToast(state.error.message.toString())
            }
        }
    }


}