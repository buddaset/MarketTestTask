package com.example.feature_main_screen.presentation.screens.main

import android.annotation.SuppressLint
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
import com.example.feature_main_screen.R
import com.example.feature_main_screen.databinding.FragmentMainBinding
import com.example.feature_main_screen.di.MainScreenComponentViewModel
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.presentation.factory.ViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {


    private val binding by viewBinding<FragmentMainBinding>()

    @Inject
    internal  lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainScreenViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<MainScreenComponentViewModel>()
            .mainScreenComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        collectFlow(viewModel.data, ::handleState)

    }

    @SuppressLint("SetTextI18n")
    private fun handleState(state: UiState<MainScreenData>) {
        Log.d("MainFragment", "state  ---$state")
        when(state) {
            is UiState.Loading -> {}
            is UiState.Success -> {
                Log.d(
                    "MainFragment",
                    "homeStore ${state.data.homeStore} \n  bestSeller ${state.data.bestSeller}"
                )
                binding.textView.text =
                    "homeStore ${state.data.homeStore} \n  bestSeller ${state.data.bestSeller}"
            }
            is UiState.Error -> {
                showToast(state.error.message.toString())
            }
        }
    }



}