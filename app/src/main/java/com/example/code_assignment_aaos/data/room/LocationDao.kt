package com.example.code_assignment_aaos.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.code_assignment_aaos.data.model.RawLocation
import kotlinx.coroutines.flow.Flow

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Dao
interface LocationDao {

    @Query("SELECT * FROM raw_locations ORDER BY timestampMillis DESC")
    fun getAllRawFlow(): Flow<List<RawLocation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaw(raw: RawLocation)

    @Query("DELETE FROM raw_locations")
    suspend fun clearAll()
}