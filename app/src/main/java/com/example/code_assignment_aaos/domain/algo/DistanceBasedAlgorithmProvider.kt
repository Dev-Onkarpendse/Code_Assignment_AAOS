package com.example.code_assignment_aaos.domain.algo

import com.example.code_assignment_aaos.data.model.CarModel

/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
interface DistanceBasedAlgorithmProvider {
    fun getAlgorithm(carModel: CarModel): DistanceBasedAlgo
}