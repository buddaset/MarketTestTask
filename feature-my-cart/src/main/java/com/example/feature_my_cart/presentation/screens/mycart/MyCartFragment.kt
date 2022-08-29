package com.example.feature_my_cart.presentation.screens.mycart

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.precentation.extension.collectFlow
import com.example.core.precentation.extension.showToast
import com.example.core.precentation.UiState
import com.example.core.precentation.common.VerticalSpaceItemDecorator
import com.example.core.precentation.onError
import com.example.core.precentation.onSuccess
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

    private fun setupMyAdapter() = with(binding.myCartRecyclerView) {
        adapter = this@MyCartFragment.adapter
        layoutManager = LinearLayoutManager(requireContext())
        addItemDecoration(VerticalSpaceItemDecorator(100))

    }


    private fun handleState(state: UiState<CartUi>) = with(binding) {
        stateView.progressBar.isVisible = state is UiState.Loading
        stateView.messageExceptionTextView.isVisible = state is UiState.Error
        myCartGroup.isVisible = state is UiState.Success

        state
            .onSuccess(::renderData)
            .onError { error -> showToast(error.toString()) }
    }

  private fun renderData(data: CartUi) = with(binding) {
      adapter.items = data.basket
      deliveryTextView.text = data.delivery
      totalTextView.text = context?.getString(R.string.total_price_pattern, data.total)
  }

}

