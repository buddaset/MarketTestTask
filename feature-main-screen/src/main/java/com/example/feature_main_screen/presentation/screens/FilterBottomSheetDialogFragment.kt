package com.example.feature_main_screen.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_main_screen.R
import com.example.feature_main_screen.databinding.FragmentFilterBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private val binding: FragmentFilterBottomSheetDialogBinding by viewBinding()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_filter_bottom_sheet_dialog, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinnerAdapters()
        setupListener()
    }

    override fun getTheme(): Int = R.style.CustomBottomSheetDialogTheme


    private fun setupSpinnerAdapters() = with(binding) {

         val simpleLayout =  R.layout.simple_spinner_layout
        spinnerBrand.adapter = ArrayAdapter(requireContext(), simpleLayout, resources.getTextArray(R.array.phones_brand_filter))
        spinnerPrice.adapter = ArrayAdapter(requireContext(), simpleLayout, resources.getTextArray(R.array.phones_price_filter))
        spinnerSize.adapter = ArrayAdapter(requireContext(), simpleLayout, resources.getTextArray(R.array.phones_size_filter))


    }

    private fun setupListener() {
        binding.closeFab.setOnClickListener { dismiss() }
        binding.doneButton.setOnClickListener { dismiss() }
    }

    }


