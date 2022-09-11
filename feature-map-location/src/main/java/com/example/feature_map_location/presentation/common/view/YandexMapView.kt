package com.example.feature_map_location.presentation.common.view

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import com.example.feature_map_location.R
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider


//class YandexMapView @JvmOverloads constructor(
//    context: Context,
//    attrs: AttributeSet? = null,
//    defStyle: Int = 0,
//    defStyleRes: Int = 0
//) : FrameLayout(context, attrs, defStyle, defStyleRes) {
//
//    private val yandexMap: MapView
//    private var mapObjectCollection: MapObjectCollection
//    private var markerTapListener: MapObjectTapListener? = null
//    private val userLocation by lazy { getUserLocationLayer() }
//
//    init {
//        LayoutInflater.from(context).inflate(R.layout.fragment_yandex_map, this, true)
//        yandexMap = findViewById(R.id.mapview)
//        mapObjectCollection = yandexMap.map.mapObjects.addCollection()
//    }
//
//    fun onStart() {
//        yandexMap.onStart()
//        MapKitFactory.getInstance().onStart()
//    }
//
//    fun onStop() {
//        yandexMap.onStop()
//        MapKitFactory.getInstance().onStop()
//    }
//
//    fun release() {
//        mapObjectCollection.clear()
//        markerTapListener = null
//    }
//
//    fun setTapListener(listener: MapObjectTapListener) {
//        markerTapListener = listener
//    }
//
//    fun showUserLocation() {
//        userLocation.apply {
//            isVisible = true
//            isHeadingEnabled = false
//
//            setAnchor(
//                PointF((yandexMap.width * 0.5f), (yandexMap.height * 0.5f)),
//                PointF((yandexMap.width * 0.5f), (yandexMap.height * 0.83f))
//            )
//            resetAnchor()
//        }
//    }
//
//    fun moveAnimatedTo(
//        latitude: Double,
//        longitude: Double,
//        zoom: Float = DEFAULT_ZOOM,
//        azimuth: Float = 0F,
//        tilt: Float = 0F,
//        animation: Animation,
//        callback: Map.CameraCallback? = null
//
//    ) {
//        yandexMap.map.move(
//            CameraPosition(Point(latitude, longitude), zoom, azimuth, tilt),
//            animation,
//            callback
//        )
//    }
//
//    fun addMarker(
//        latitude: Double,
//        longitude: Double,
//        @DrawableRes imageRes: Int,
//        userData: Any? = null
//    ): PlacemarkMapObject {
//        val marker = mapObjectCollection.addPlacemark(
//            Point(latitude, longitude),
//            ImageProvider.fromResource(context, imageRes)
//        )
//        marker.userData = userData
//        markerTapListener?.let { marker.addTapListener(it) }
//        return marker
//    }
//
//    fun getZoom() = yandexMap.map.cameraPosition.zoom
//
//    private fun getUserLocationLayer() =
//        MapKitFactory.getInstance().createUserLocationLayer(yandexMap.mapWindow)
//
//    companion object {
//
//        const val DEFAULT_ZOOM = 10F
//
//        fun initialize(context: Context, apiKey: String) {
//            MapKitFactory.setApiKey(apiKey)
//        }
//    }
//}