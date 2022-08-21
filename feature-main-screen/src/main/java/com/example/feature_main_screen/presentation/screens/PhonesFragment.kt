package com.example.feature_main_screen.presentation.screens

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
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.MainScreenAdapter
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


    private val adapter = MainScreenAdapter(
        this::onProductClick
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

    private fun  onProductClick(item: DisplayableItem ) {
        Log.d("MainScreen", "id item ---- ${item.itemId}")
        navigate( actionId = R.id.action_tabBarFragment_to_productDetailsFragment,
        hostId =global_host)
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


    }

}




internal data class ListBestSeller(
    val title: String = "Best Seller",
   val  bestSellers: List<BestSeller>
): DisplayableItem {
    override val itemId: Long = title.hashCode().toLong()
}

internal data class ListHotSales(
    val title: String = "Hot Sales",
    val hotSales : List<HotSales>
) : DisplayableItem {
    override val itemId: Long = title.hashCode().toLong()
}