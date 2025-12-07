package com.example.code_assignment_aaos.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.code_assignment_aaos.data.model.RawLocation

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Database(entities = [RawLocation::class], version = 1, exportSchema = false)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}


