package com.devrachit.mapsample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.data.kml.KmlLayer
import java.io.IOException

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
//        val kmlLayer = KmlLayer(googleMap, R.raw.sample3, this)
//        kmlLayer.addLayerToMap()
        try {

            val kmlLayer = KmlLayer(googleMap, R.raw.sample3, this)

            kmlLayer.addLayerToMap()

            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(37.7749, -122.4194), 10f)
            googleMap.moveCamera(cameraUpdate)

        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }
}