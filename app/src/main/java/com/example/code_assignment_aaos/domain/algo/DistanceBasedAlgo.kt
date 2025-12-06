package com.example.code_assignment_aaos.domain.algo

import com.example.code_assignment_aaos.data.model.RawLocation

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 06-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
interface DistanceBasedAlgo {
    fun filter(rawLocations: List<RawLocation>, carLat: Double, carLong: Double): List<RawLocation>
}