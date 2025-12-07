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
class CarModelThreeAlgo @Inject constructor() : DistanceBasedAlgo {
    override fun filter(
        rawLocations: List<RawLocation>,
        carLat: Double,
        carLong: Double
    ): List<RawLocation> {
        val distance = CarModelTwoAlgo().filter(rawLocations, carLat, carLong)

        return distance.groupBy { it.type }
            .mapValues { (_, group) ->
                if (group.size > 1) {
                    group.take(1)
                } else group
            }.values.flatten()

    }
}
