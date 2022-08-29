package com.example.feature_product_details.presentation.screens.product_details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.core.common.navigation.navigate
import com.example.core.precentation.extension.collectFlow
import com.example.core.precentation.extension.showToast
import com.example.core.precentation.UiState
import com.example.core.precentation.onError
import com.example.core.precentation.onSuccess
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_product_details.R
import com.example.feature_product_details.databinding.FragmentProductDetailsBinding
import com.example.feature_product_details.di.ProductDetailsComponentViewModel
import com.example.feature_product_details.presentation.common.model.SectionProductDetails
import com.example.feature_product_details.presentation.adapter.productimage.ProductImageAdapter
import com.example.feature_product_details.presentation.adapter.viewpager.SectionPagerAdapter
import com.example.feature_product_details.presentation.common.factory.ViewModelFactory
import com.example.feature_product_details.presentation.common.model.ProductDetailsUi
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

        myCartImageButton.setOnClickListener { navigate(R.id.action_productDetailsFragment_to_myCartFragment) }
    }

    private fun setupImageProductAdapter() = with(binding) {
        productImageRecyclerView.adapter = adapter
        val layoutManager = GalleryLayoutManager.create {
            itemSpace = ITEM_SPACE_IMAGE
            viewTransformListener = SimpleViewTransformListener(SCALE_X, SCALE_Y)
        }
        productImageRecyclerView.layoutManager = layoutManager
        productImageRecyclerView.setHasFixedSize(true)

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


    private fun handleState(state: UiState<ProductDetailsUi>) = with(binding) {
        stateView.progressBar.isVisible = state is UiState.Loading
        stateView.messageExceptionTextView.isVisible = state is UiState.Error
        productDetailsGroup.isVisible = state is UiState.Success

        state
            .onSuccess(::renderData)
            .onError { error -> showToast(error.toString()) }
    }


    private fun renderData(data: ProductDetailsUi) = with(binding) {
        adapter.items = data.images
        productRating.rating = data.rating
        addToCartButton.text = context?.getString(R.string.add_to_cart_1500, data.price)
        productNameTextView.text = data.title
        if (data.isFavorites) favoriteImageButton.setImageResource(R.drawable.ic_favorite_product_details_on)

    }

    companion object {

        const val ITEM_SPACE_IMAGE = 100
        const val SCALE_X = 1f
        const val SCALE_Y = 1.2f
    }

}