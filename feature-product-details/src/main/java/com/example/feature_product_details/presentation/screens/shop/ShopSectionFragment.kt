package com.example.feature_product_details.presentation.screens.shop

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.core.precentation.extension.collectFlow
import com.example.core.precentation.UiState
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_product_details.R
import com.example.feature_product_details.databinding.FragmentShopSectionBinding
import com.example.feature_product_details.di.ProductDetailsComponentViewModel
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.presentation.factory.ViewModelFactory
import com.example.feature_product_details.presentation.screens.product_details.ProductDetailsViewModel
import javax.inject.Inject


class ShopSectionFragment : Fragment(R.layout.fragment_shop_section) {

    private val binding: FragmentShopSectionBinding by viewBinding()

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ProductDetailsViewModel
            by viewModels(ownerProducer = ::requireParentFragment) {
                viewModelFactory
            }


    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<ProductDetailsComponentViewModel>()
            .productDetailsComponent.inject(this)
        super.onAttach(context)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("LifeDetails", "viewModel -- shop  ---  v${viewModel.hashCode()}")


        collectFlow(viewModel.data, ::handleState)

    }

    private fun handleState(state: UiState<ProductDetails>) = with(binding) {
        if (state is UiState.Success) {
            val data = state.data
            processorTextView.text = data.CPU
            cameraTextView.text = data.camera
            firstCapacityRadioButton.text =
                context?.getString(R.string.capacity_radio_button, data.capacity[0])
            secondCapacityRadioButton.text =
                context?.getString(R.string.capacity_radio_button, data.capacity[1])
            firstColorRadioButton.background.setColorFilter(
                Color.parseColor(data.color[0]),
                PorterDuff.Mode.SRC_ATOP
            )
            secondColorRadioButton.background.setColorFilter(
                Color.parseColor(data.color[1]),
                PorterDuff.Mode.SRC_ATOP
            )
            sdTextView.text = data.sd
            ssdTextView.text = data.ssd


        }

    }


//  {
//    "CPU": "Exynos 990",
//    "camera": "108 + 12 mp",
//    "capacity": [
//    "126",
//    "252"
//    ],
//    "color": [
//    "#772D03",
//    "#010035"
//    ],
//    "id": "3",
//    "images": [
//    "https://avatars.mds.yandex.net/get-mpic/5235334/img_id5575010630545284324.png/orig",
//    "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg"
//    ],
//    "isFavorites": true,
//    "price": 1500,
//    "rating": 4.5,
//    "sd": "256 GB",
//    "ssd": "8 GB",
//    "title": "Galaxy Note 20 Ultra"
//  }


}