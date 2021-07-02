package com.clovertech.autolib.views.ui.vehiculedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.clovertech.autolib.databinding.FragmentVehiculeBinding
import com.clovertech.autolib.model.Vehicle
import com.clovertech.autolib.viewmodel.VehicleViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

class VehicleFragment : Fragment(),OnMapReadyCallback {

    private lateinit var binding: FragmentVehiculeBinding
    private val viewModel: VehicleViewModel by activityViewModels()
    private var vehicleMap: GoogleMap? = null
    private lateinit var mapView: MapView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentVehiculeBinding
            .inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: VehicleFragmentArgs by navArgs()
        val idVehicle = args.idVehicule
        var vehicle = Vehicle(0,"",""
            ,"","","","","",""
            ,"",0,"",0F,0F,"")
        /*if (idVehicle != 0){
            viewModel.getVehicleById(idVehicle)
            vehicle = viewModel.vehicle
        }*/

        mapView = binding.vehicleMap
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    override fun onMapReady(gmap: GoogleMap) {
        vehicleMap = gmap
        gmap.isMyLocationEnabled = true
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}