package com.example.code_assignment_aaos.domain.algo

import com.example.code_assignment_aaos.data.model.PlaceType
import com.example.code_assignment_aaos.data.model.RawLocation
import com.example.code_assignment_aaos.domain.Utils.DistanceUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 06-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Singleton
class CarModelTwoAlgo @Inject constructor() : DistanceBasedAlgo {
    override fun filter(
        rawLocations: List<RawLocation>,
        carLat: Double,
        carLong: Double
    ): List<RawLocation> {
        return rawLocations.filter { rawLocation ->
            val distance = DistanceUtils.distanceInKM(
                carLat,
                carLong,
                rawLocation.latitude,
                rawLocation.longitude
            )

            when (rawLocation.type) {
                PlaceType.CHARGING_STATION -> distance <= 4
                PlaceType.RESTAURANT -> distance <= 1
                PlaceType.PARKING -> distance <= 2
                PlaceType.HOTEL -> distance <= 3
            }
        }
    }
}
