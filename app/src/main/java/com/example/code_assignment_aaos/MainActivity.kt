package com.example.code_assignment_aaos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.code_assignment_aaos.data.model.CarModel
import com.example.code_assignment_aaos.data.model.PlaceType
import com.example.code_assignment_aaos.domain.UiState
import com.example.code_assignment_aaos.presentation.LocationViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        observeData()
        testData()
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.uiState.collect { uiState ->
                        when (uiState) {
                            is UiState.Success -> {
                                println("${uiState.data.size} locations")
                                uiState.data.forEach {
                                    println("  → ${it.distanceKm} km")
                                }
                            }

                            is UiState.Error -> println("Error: ${uiState.message}")
                            is UiState.Empty -> println("Empty: ${uiState.message}")
                            is UiState.Loading -> println("Loading")

                        }
                    }
                }

                launch {
                    viewModel.allRawLocations.collect {
                        println("All locations: ${it.size} locations")
                    }
                }
            }
        }
    }


    private fun testData() {
        //Add dummy pune location
        viewModel.recordSampleLocation(18.0760, 73.6898, PlaceType.CHARGING_STATION)
        viewModel.recordSampleLocation(18.0111, 73.5366, PlaceType.HOTEL)
        viewModel.recordSampleLocation(18.0546, 73.7890, PlaceType.PARKING)
        viewModel.recordSampleLocation(18.9123, 73.5799, PlaceType.RESTAURANT)

        viewModel.loadFilteredLocations(CarModel.CAR_MODEL_2, 18.0560, 73.6777)
    }
}