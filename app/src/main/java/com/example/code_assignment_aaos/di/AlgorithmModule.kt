package com.example.code_assignment_aaos.di

import com.example.code_assignment_aaos.domain.algo.DefaultDistanceBasedAlgorithmProvider
import com.example.code_assignment_aaos.domain.algo.DistanceBasedAlgorithmProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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
abstract class AlgorithmModule {

    @Binds
    @Singleton
    abstract fun bindDistanceBasedAlgorithmProvider(
        defaultDistanceBasedAlgorithmProvider: DefaultDistanceBasedAlgorithmProvider
    ): DistanceBasedAlgorithmProvider
}