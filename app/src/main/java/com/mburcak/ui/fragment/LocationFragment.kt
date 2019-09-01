package com.mburcak.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// map
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.mburcak.R

class LocationFragment : Fragment(), OnMapReadyCallback {

    internal lateinit var locationView: View
    internal lateinit var mapView: MapView
    internal lateinit var map: GoogleMap
    internal lateinit var marker: Marker
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        locationView = inflater.inflate(R.layout.fragment_location, container, false)

        mapView = locationView.findViewById(R.id.mapView)

        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync(this)

        return locationView
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val latLng = LatLng(40.9741701, 29.0957554)

        marker = map.addMarker(MarkerOptions().position(latLng).title("MertYemek"))
        marker.isVisible = false


        map.addMarker(
            MarkerOptions().position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map3))
                .title("Mert Yemek")
                .snippet("Kozyatağı, Değirmenyolu Sokak Şaşmaz Sitesi\n 2/3 D:B-1 Blok, 34742 Kadıköy/İstanbul")
        )


        map.setOnInfoWindowClickListener {
            val url =
                "https://www.google.com.tr/maps/place/Mert+Yemek+Kozyatağı+Catering+%26+Self+Servis/@40.9741701,29.0957554,17z/data=!3m1!4b1!4m5!3m4!1s0x14cac64c2222d57f:0xaadf5a01d33d8d2a!8m2!3d40.9741701!4d29.0979441"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        map.moveCamera(CameraUpdateFactory.newLatLng(latLng))

        val cameraPosition = CameraPosition.builder()
            .target(latLng)
            .zoom(15f)
            .bearing(0f)
            .tilt(45f)
            .build()

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
