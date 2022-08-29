package com.example.feature_my_cart.presentation.screens.mycart

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.precentation.extension.collectFlow
import com.example.core.precentation.extension.showToast
import com.example.core.precentation.UiState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_my_cart.R
import com.example.feature_my_cart.databinding.FragmentMyCartBinding
import com.example.feature_my_cart.di.MyCartComponentViewModel
import com.example.feature_my_cart.presentation.adapters.cart_adapter.MyCartAdapter
import com.example.feature_my_cart.presentation.common.factory.ViewModelFactory
import com.example.feature_my_cart.presentation.common.model.CartUi
import javax.inject.Inject


class MyCartFragment : Fragment(R.layout.fragment_my_cart) {

    private val binding: FragmentMyCartBinding by viewBinding()
    private val adapter by lazy { MyCartAdapter() }

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MyCartViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<MyCartComponentViewModel>()
            .myCartComponent.inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMyAdapter()
        setupClickListeners()

        collectFlow(viewModel.data, ::handleState)
    }

    private fun setupClickListeners() {

        binding.backImageButton.setOnClickListener { findNavController().popBackStack() }
    }

    private fun setupMyAdapter() {
        binding.myCartRecyclerView.adapter = adapter
        binding.myCartRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


    private fun handleState(state: UiState<CartUi>) {
        Log.d("MyCartFragment", "state  ---$state")
        when(state) {
            is UiState.Loading -> {}
            is UiState.Success -> {

                Log.d("MyCartFragment", "data ---${state.data}")
                renderData(state.data)

            }
            is UiState.Error -> {
                showToast(state.error.message.toString())
            }
        }
    }

  private fun renderData(data: CartUi) = with(binding) {


      adapter.items = data.basket
      deliveryTextView.text = data.delivery
      totalTextView.text = context?.getString(R.string.total_price_pattern, data.total)




  }




}

