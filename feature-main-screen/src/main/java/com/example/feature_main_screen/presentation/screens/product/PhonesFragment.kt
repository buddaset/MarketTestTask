package com.example.feature_main_screen.presentation.screens.product

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.core.common.navigation.navigate
import com.example.core.R.id.global_host
import com.example.core.precentation.extension.collectFlow
import com.example.core.precentation.extension.showToast
import com.example.core.precentation.UiState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_main_screen.R
import com.example.feature_main_screen.databinding.FragmentPhonesBinding
import com.example.feature_main_screen.di.MainScreenComponentViewModel
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.MainScreenAdapter
import com.example.feature_main_screen.presentation.factory.ViewModelFactory
import javax.inject.Inject

class PhonesFragment : Fragment(R.layout.fragment_phones) {

    private val binding by viewBinding<FragmentPhonesBinding>()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: ProductViewModel by viewModels { viewModelFactory }

    private val adapter = MainScreenAdapter(this::onProductClick)


    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<MainScreenComponentViewModel>()
            .mainScreenComponent.inject(this)
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        collectFlow(viewModel.data, ::handleState)

    }

    private fun onProductClick(item: ItemUi) {

        navigate(
            actionId = R.id.action_tabBarFragment_to_productDetailsFragment,
            hostId = global_host
        )
    }


    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter
    }


    private fun handleState(state: UiState<MainScreenDataUi>) {
        Log.d("MainFragment", "state  ---$state")
        when (state) {
            is UiState.Loading -> {}
            is UiState.Success -> {

                Log.d("MainFragment", "hotSales ---${state.data.hotSales}")
                renderData(state.data)

            }
            is UiState.Error -> {
                showToast(state.error.message.toString())
            }
        }
    }

    private fun renderData(data: MainScreenDataUi) {
        adapter.items = listOf( data.hotSales , data.bestSeller)

    }

}



