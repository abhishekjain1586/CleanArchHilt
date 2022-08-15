package com.example.cleanarchhilt.common.injection

import com.example.cleanarchhilt.home.data.LaunchRemoteDataSource
import com.example.cleanarchhilt.home.data.LaunchRepository
import com.example.cleanarchhilt.home.domain.usecase.GetCompanyDetailUseCase
import com.example.cleanarchhilt.home.domain.usecase.GetLaunchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideLaunchRemoteDataSource(retrofit: Retrofit) =
        retrofit.create(LaunchRemoteDataSource::class.java)

    @Singleton
    @Provides
    fun provideLaunchRepository(launchesRemoteDataSource: LaunchRemoteDataSource) =
        LaunchRepository(launchesRemoteDataSource = launchesRemoteDataSource)

    @Singleton
    @Provides
    fun provideCompanyDetailUseCase(launchRepository: LaunchRepository) =
        GetCompanyDetailUseCase(launchRepository = launchRepository)

    @Singleton
    @Provides
    fun provideLaunchesUseCase(launchRepository: LaunchRepository) =
        GetLaunchesUseCase(launchRepository = launchRepository)
}