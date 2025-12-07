package com.example.code_assignment_aaos.domain.usecase

import com.example.code_assignment_aaos.data.model.PlaceType
import com.example.code_assignment_aaos.data.model.RawLocation
import com.example.code_assignment_aaos.data.room.LocationDao
import javax.inject.Inject

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
class RecordLocationUseCase @Inject constructor(private val locationDao: LocationDao) {

    suspend operator fun invoke(type: PlaceType, latitude: Double, longitude: Double) {
        val location = RawLocation(
            type = type,
            latitude = latitude,
            longitude = longitude,
            timestampMillis = System.currentTimeMillis()
        )
        locationDao.insertRaw(location)
    }
}