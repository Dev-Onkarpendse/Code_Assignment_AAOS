package com.example.code_assignment_aaos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code_assignment_aaos.data.model.CarModel
import com.example.code_assignment_aaos.data.model.PlaceType
import com.example.code_assignment_aaos.data.repository.LocationRepository
import com.example.code_assignment_aaos.domain.UiState
import com.example.code_assignment_aaos.domain.usecase.ClearHistoryUseCase
import com.example.code_assignment_aaos.domain.usecase.FilteredLocationsUseCase
import com.example.code_assignment_aaos.domain.usecase.RecordLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@HiltViewModel
class LocationViewModel @Inject constructor(
    private val recodeLocationUseCase: RecordLocationUseCase,
    private val getFilteredLocationsUseCase: FilteredLocationsUseCase,
    private val clearUseCase: ClearHistoryUseCase,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    val allRawLocations = locationRepository.allRawLocation

    fun loadFilteredLocations(carModel: CarModel, carLat: Double, carLong: Double) {

        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val locations = locationRepository.allRawLocation.first()
                val filtered = getFilteredLocationsUseCase(
                    carModel = carModel,
                    carLat = carLat,
                    carLong = carLong,
                    rawLocations = locations

                )
                if (filtered.isEmpty()) {
                    _uiState.value = UiState.Empty("No locations within range")
                } else {
                    _uiState.value = UiState.Success(filtered)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Error filtering locations: ${e.message}")
            }
        }
    }

    fun recordSampleLocation(latitude: Double, longitude: Double, type: PlaceType) {
        viewModelScope.launch {
            recodeLocationUseCase(type, latitude, longitude)

            loadFilteredLocations(CarModel.CAR_MODEL_2, 18.0760, 73.8777)
        }

    }

    fun clearHistory() {
        viewModelScope.launch {
            clearUseCase()
            _uiState.value = UiState.Empty("History cleared")
        }
    }
}