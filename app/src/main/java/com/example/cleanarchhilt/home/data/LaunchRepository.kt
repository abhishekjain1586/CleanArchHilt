package com.example.cleanarchhilt.home.data

import com.example.cleanarchhilt.common.data.repository.BaseRepository
import com.example.cleanarchhilt.common.network.Resource
import com.example.cleanarchhilt.home.domain.model.CompanyDetail
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@ViewModelScoped
class LaunchRepository @Inject constructor(
    private val launchesRemoteDataSource: LaunchRemoteDataSource,
) : BaseRepository() {

    suspend fun getCompanyDetail(): Flow<Resource<CompanyDetail>> = toResourceFlow(
        response = launchesRemoteDataSource.getCompanyDetail(),
        transform = LaunchMapper::mapToCompanyDetail,
    )

    suspend fun getLaunches() = toResourceFlow(
        response = launchesRemoteDataSource.getLaunches(),
        transform = LaunchMapper::mapToLaunches,
    )
}
