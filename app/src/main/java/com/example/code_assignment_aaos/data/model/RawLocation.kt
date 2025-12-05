package com.example.code_assignment_aaos.data.model

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 06-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
data class RawLocation (
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val timestampMillis: Long,
    val type: PlaceType
){
    companion object {

        fun createSample(
            id: Long,
            lat: Double,
            lon: Double,
            type: PlaceType
        ): RawLocation {
            return RawLocation(
                id = id,
                latitude = lat,
                longitude = lon,
                timestampMillis = System.currentTimeMillis(),
                type = type
            )
        }
    }
}