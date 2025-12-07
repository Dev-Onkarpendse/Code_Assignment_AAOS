package com.example.code_assignment_aaos.data.repository

import com.example.code_assignment_aaos.data.model.RawLocation
import com.example.code_assignment_aaos.data.room.LocationDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Singleton
class LocationRepository @Inject constructor(private val locationDao: LocationDao) {

    val allRawLocation: Flow<List<RawLocation>> = locationDao.getAllRawFlow()
}
