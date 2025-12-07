package com.example.code_assignment_aaos.di

import android.content.Context
import androidx.room.Room
import com.example.code_assignment_aaos.data.room.LocationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LocationDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            LocationDatabase::class.java
        ).build()
    }

    @Provides
    fun providesDao(database: LocationDatabase) = database.locationDao()


}


