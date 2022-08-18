package com.example.feature_main_screen.presentation.screens

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.core.precentation.Extension.collectFlow
import com.example.core.precentation.Extension.showToast
import com.example.core.precentation.UiState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_main_screen.R
import com.example.feature_main_screen.databinding.FragmentPhonesBinding
import com.example.feature_main_screen.di.MainScreenComponentViewModel
import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.domain.model.HotSales
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.DisplayableItem
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.MainScreenDelegates
import com.example.feature_main_screen.presentation.factory.ViewModelFactory
import com.example.feature_main_screen.presentation.screens.main.MainScreenViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import javax.inject.Inject

class PhonesFragment : Fragment(R.layout.fragment_phones) {

    private val binding by viewBinding<FragmentPhonesBinding>()

    @Inject
    internal  lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainScreenViewModel by viewModels { viewModelFactory }


    private val adapter = ListDelegationAdapter<List<DisplayableItem>>(
        MainScreenDelegates.bestSellerHorizontalAdapterDelegate(),
        MainScreenDelegates.hotSaleSHorizontalAdapterDelegate()
    )

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

    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter

    }


    private fun handleState(state: UiState<MainScreenData>) {
        Log.d("MainFragment", "state  ---$state")
        when(state) {
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

    private fun renderData(data: MainScreenData) {
        adapter.items = listOf( ListHotSales(hotSales = data.hotSales), ListBestSeller(bestSellers = data.bestSeller ),)
        adapter.notifyDataSetChanged()

    }

}


data class TitleEx(
    val title: String ,
    val button : String = "see more"
) : DisplayableItem

internal data class ListBestSeller(
   val  bestSellers: List<BestSeller>
): DisplayableItem

internal data class ListHotSales(
    val hotSales : List<HotSales>
) : DisplayableItem