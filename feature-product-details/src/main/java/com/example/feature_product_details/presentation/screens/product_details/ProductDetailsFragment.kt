package com.example.feature_product_details.presentation.screens.product_details

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.core.common.navigation.navigate
import com.example.core.precentation.extension.collectFlow
import com.example.core.precentation.extension.showToast
import com.example.core.precentation.UiState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_product_details.R
import com.example.feature_product_details.databinding.FragmentProductDetailsBinding
import com.example.feature_product_details.di.ProductDetailsComponentViewModel
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.model.SectionProductDetails
import com.example.feature_product_details.presentation.adapter.productimage.ProductImageAdapter
import com.example.feature_product_details.presentation.adapter.viewpager.SectionPagerAdapter
import com.example.feature_product_details.presentation.factory.ViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator


import com.peceoqicka.x.gallerylayoutmanager.GalleryLayoutManager
import com.peceoqicka.x.gallerylayoutmanager.SimpleViewTransformListener

import javax.inject.Inject

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {

    private val binding: FragmentProductDetailsBinding by viewBinding()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ProductDetailsViewModel by viewModels { viewModelFactory }

    private val adapter = ProductImageAdapter()


    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<ProductDetailsComponentViewModel>()
            .productDetailsComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupImageProductAdapter()
        setupPageAdapter()
        setupClickListener()

        collectFlow(viewModel.data, ::handleState)
    }

    private fun setupClickListener() = with(binding) {

        backImageButton.setOnClickListener { findNavController().popBackStack() }

        myCartImageButton.setOnClickListener { navigate(R.id.action_productDetailsFragment_to_myCartFragment)}
    }

    private fun setupImageProductAdapter() = with(binding) {
        productImageRecyclerView.adapter = adapter
        val layoutManager = GalleryLayoutManager.create {
            itemSpace = 100
            viewTransformListener = SimpleViewTransformListener(1.0f, 1.2f)
        }
        productImageRecyclerView.layoutManager = layoutManager


    }

    private fun setupPageAdapter() = with(binding) {
        val sections = getSectionsProductDetails()
        sectionViewPager.adapter = SectionPagerAdapter(this@ProductDetailsFragment, sections)

        TabLayoutMediator(sectionTabLayout, sectionViewPager) { tab, position ->
            tab.text = sections[position].title

        }.attach()
    }


    private fun getSectionsProductDetails(): List<SectionProductDetails> =
        SectionProductDetails.values().toList()


    private fun handleState(state: UiState<ProductDetails>) {
        Log.d("ProductDetails", "state  ---$state")
        when (state) {
            is UiState.Loading -> {}
            is UiState.Success -> {
                val data = state.data

                Log.d("ProductDetails", "productDetails ---${state.data}")
                adapter.items = data.images
                binding.productRating.rating = data.rating.toFloat()
                binding.addToCartButton.text =
                    context?.getString(R.string.add_to_cart_1500, data.price)
                binding.productNameTextView.text = data.title
                if (data.isFavorites) binding.favoriteImageButton.setImageResource(R.drawable.ic_favorite_product_details_on)


            }
            is UiState.Error -> {
                showToast(state.error.message.toString())
            }
        }
    }


}