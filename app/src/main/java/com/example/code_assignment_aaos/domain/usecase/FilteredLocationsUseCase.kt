package com.example.code_assignment_aaos.domain.usecase

import com.example.code_assignment_aaos.data.model.CarModel
import com.example.code_assignment_aaos.data.model.FilteredLocation
import com.example.code_assignment_aaos.data.model.RawLocation
import com.example.code_assignment_aaos.domain.Utils.DistanceUtils
import com.example.code_assignment_aaos.domain.algo.DistanceBasedAlgorithmProvider
import javax.inject.Inject

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
class FilteredLocationsUseCase @Inject constructor(private val algo: DistanceBasedAlgorithmProvider) {

    operator fun invoke(
        carModel: CarModel,
        carLat: Double,
        carLong: Double,
        rawLocations: List<RawLocation>
    ): List<FilteredLocation> {
        val algorithm = algo.getAlgorithm(carModel)
        val filteredLocations = algorithm.filter(rawLocations, carLat, carLong)
        return filteredLocations.map { raw ->
            FilteredLocation(
                raw,
                DistanceUtils.distanceInKM(carLat, carLong, raw.latitude, raw.longitude)
            )
        }
    }
}
