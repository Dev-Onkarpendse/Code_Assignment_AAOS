package com.example.code_assignment_aaos.domain.usecase

import com.example.code_assignment_aaos.data.room.LocationDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Singleton
class ClearHistoryUseCase @Inject constructor(private val locationDao: LocationDao) {

    suspend operator fun invoke() {
        locationDao.clearAll()
    }
}