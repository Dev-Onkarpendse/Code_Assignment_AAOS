package com.example.code_assignment_aaos.domain.Utils

import kotlin.math.cos
import kotlin.math.sqrt

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 06-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
object DistanceUtils {

    fun distanceInKM(carLat: Double, carLong: Double, locationLat: Double, locationLong: Double): Double {
        val latDiff = Math.toRadians(locationLat - carLat) * 111
        val longDiff = Math.toRadians(locationLong - carLong) * 111 * cos(Math.toRadians(carLat))
            return sqrt(latDiff * latDiff + longDiff * longDiff)
    }
}