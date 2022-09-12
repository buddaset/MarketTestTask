package com.example.feature_map_location.presentation.screens.maplocation


import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.PointF
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_map_location.R
import com.example.feature_map_location.databinding.FragmentYandexMapBinding
import com.example.feature_map_location.presentation.common.model.Marker
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import com.yandex.runtime.image.ImageProvider

class YandexMapFragment : Fragment(R.layout.fragment_yandex_map) {

    private val binding: FragmentYandexMapBinding by viewBinding()
    private var isRationalShown = false
    private var permissionLocation = false
    private val userLocationLayer by lazy { userLocationLayer() }

    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>


    override fun onAttach(context: Context) {
        super.onAttach(context)

        requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) onLocationPermissionGranted()
            else onLocationPermissionNotGranted()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(YANDEX_MAP_API_KEY)
        MapKitFactory.initialize(requireContext())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addMarkers()
        setStartPosition()
        setupClickListener()

    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onDetach() {
        requestPermissionLauncher.unregister()
        super.onDetach()
    }





    private fun setStartPosition() {
        binding.mapView.map.move(
            CameraPosition(Point(55.751574, 37.573856), 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )
    }


    private fun setupClickListener() {

        binding.findMe.setOnClickListener {
            if (permissionLocation) {
                moveCameraToUserPosition()
            } else {
                checkGrantedPermission()
            }

        }
    }


    private val markers = listOf(
        Marker(latitude = 55.741570, longitude = 37.543858),
        Marker(latitude = 55.731565, longitude = 37.553856),
        Marker(latitude = 55.751574, longitude = 37.503866),
        Marker(latitude = 55.751570, longitude = 37.513850),
        Marker(latitude = 55.751545, longitude = 37.593866),
        Marker(latitude = 55.701584, longitude = 37.573866),
        Marker(latitude = 55.781587, longitude = 37.573839),
        Marker(latitude = 55.791553, longitude = 37.573858),
        Marker(latitude = 55.851599, longitude = 37.673844),
        Marker(latitude = 55.751574, longitude = 37.573856)
    )

    private fun addMarkers() {
        val collection = binding.mapView.map.mapObjects.addCollection()
        markers.forEach { marker ->
            collection.addPlacemark(
                Point(marker.latitude, marker.longitude),
                ImageProvider.fromResource(context, marker.iconId)
            )
        }
    }


    private fun checkGrantedPermission() {
        activity?.let {
            when {
                ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED -> onLocationPermissionGranted()

                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) ->
                    showLocationPermissionExplanationDialog()

                isRationalShown -> showLocationPermissionDeniedDialog()

                else -> requestLocationPermission()
            }

        }
    }

    private fun onLocationPermissionNotGranted() {
        Toast.makeText(context, R.string.permission_not_granted_text, Toast.LENGTH_SHORT).show()
    }

    private fun onLocationPermissionGranted() {
        onMapReady()
    }

    private fun setAnchor() = with(binding) {
        userLocationLayer.setAnchor(
            PointF((mapView.width * 0.5).toFloat(), (mapView.height * 0.5).toFloat()),
            PointF((mapView.width * 0.5).toFloat(), (mapView.height * 0.83).toFloat())
        )
    }



    private fun onMapReady()  {
        userLocationLayer.apply {
            isVisible = true
            isHeadingEnabled = true

            setObjectListener( object :UserLocationObjectListener{
                override fun onObjectAdded(p0: UserLocationView) { setAnchor() }
                override fun onObjectRemoved(p0: UserLocationView) {}
                override fun onObjectUpdated(p0: UserLocationView, p1: ObjectEvent) {}

            })
            moveCameraToUserPosition()
            resetAnchor()

        }


    }

    private fun moveCameraToUserPosition() {
        if (userLocationLayer.cameraPosition() != null) {
            val routeStartLocation = userLocationLayer.cameraPosition()!!.target
            binding.mapView.map.move(
                CameraPosition(routeStartLocation, 16f, 0f, 0f),
                Animation(Animation.Type.SMOOTH, 1f),
                null
            )
        } else {
            binding.mapView.map.move(CameraPosition(Point(0.0, 0.0), 16f, 0f, 0f))
        }
    }


    private fun userLocationLayer(): UserLocationLayer =
        MapKitFactory.getInstance().createUserLocationLayer(binding.mapView.mapWindow)



    private fun requestLocationPermission() {
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private fun showLocationPermissionExplanationDialog() {
        context?.let {
            AlertDialog.Builder(it)
                .setMessage(R.string.permission_dialog_explanation_text)
                .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                    isRationalShown = true
                    requestLocationPermission()
                    dialog.dismiss()

                }
                .setNegativeButton(R.string.dialog_negative_button) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun showLocationPermissionDeniedDialog() {
        context?.let {
            androidx.appcompat.app.AlertDialog.Builder(it)
                .setMessage(R.string.permission_dialog_denied_text)
                .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                    startActivity(
                        Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:" + it.packageName)
                        )
                    )
                    dialog.dismiss()
                }
                .setNegativeButton(R.string.dialog_negative_button) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    companion object {

        const val YANDEX_MAP_API_KEY =
            "5dfcd123-bcba-48e9-85bc-7b96ee882b62" // to do move to local property
    }

}

