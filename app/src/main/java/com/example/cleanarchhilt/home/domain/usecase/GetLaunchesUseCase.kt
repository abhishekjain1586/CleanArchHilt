package com.example.cleanarchhilt.home.domain.usecase

import com.example.cleanarchhilt.home.data.LaunchRepository
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor(private val launchRepository: LaunchRepository) {

    suspend operator fun invoke() = launchRepository.getLaunches()
}