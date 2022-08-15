package com.example.cleanarchhilt.home.domain.usecase

import com.example.cleanarchhilt.home.data.LaunchRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetLaunchesUseCase @Inject constructor(private val launchRepository: LaunchRepository) {

    suspend operator fun invoke() = launchRepository.getLaunches()
}