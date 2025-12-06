package com.example.code_assignment_aaos.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 06-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Entity(tableName = "raw_locations")
data class RawLocation (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val latitude: Double,
    val longitude: Double,
    val timestampMillis: Long,
    val type: PlaceType
)