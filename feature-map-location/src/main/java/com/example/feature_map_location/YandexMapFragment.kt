package com.example.feature_map_location


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_map_location.databinding.FragmentYandexMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

class YandexMapFragment : Fragment(R.layout.fragment_yandex_map) {

    private val binding: FragmentYandexMapBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(YANDEX_MAP_API_KEY)
        MapKitFactory.initialize(requireContext())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mapview.map.move(
            CameraPosition( Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

     override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }




    companion object {

      const val  YANDEX_MAP_API_KEY="5dfcd123-bcba-48e9-85bc-7b96ee882b62"
    }

}