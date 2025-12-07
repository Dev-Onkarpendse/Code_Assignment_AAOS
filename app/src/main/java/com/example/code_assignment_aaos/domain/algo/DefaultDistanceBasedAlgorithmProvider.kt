package com.example.code_assignment_aaos.domain.algo

import com.example.code_assignment_aaos.data.model.CarModel
import javax.inject.Inject


/**
 * Created by Onkar Pendse  pendseomkar92@gmail.com
 *  on 07-12-2025.
 *  For More Information Contact me!!!.
 *          !!  Thank You  !!
 */
class DefaultDistanceBasedAlgorithmProvider @Inject constructor(
    private val carModelTwoAlgo: CarModelTwoAlgo,
    private val carModelThreeAlgo: CarModelThreeAlgo
) : DistanceBasedAlgorithmProvider {
    override fun getAlgorithm(carModel: CarModel): DistanceBasedAlgo {
        return when (carModel) {
            CarModel.CAR_MODEL_2 -> carModelTwoAlgo
            CarModel.CAR_MODEL_3 -> carModelThreeAlgo
            else -> { carModelTwoAlgo}
        }
    }
}