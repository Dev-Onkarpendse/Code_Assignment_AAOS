package com.example.code_assignment_aaos.domain

import com.example.code_assignment_aaos.data.model.FilteredLocation

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
sealed class UiState {

    object Loading : UiState()
    data class Success(val data: List<FilteredLocation>) : UiState()
    data class Error(val message: String) : UiState()
    data class Empty(val message: String) : UiState()
}