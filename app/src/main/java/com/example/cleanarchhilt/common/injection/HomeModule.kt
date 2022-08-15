package com.example.cleanarchhilt.common.injection

import com.example.cleanarchhilt.home.data.LaunchRemoteDataSource
import com.example.cleanarchhilt.home.data.LaunchRepository
import com.example.cleanarchhilt.home.domain.usecase.GetCompanyDetailUseCase
import com.example.cleanarchhilt.home.domain.usecase.GetLaunchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @ViewModelScoped
    @Provides
    fun provideLaunchRemoteDataSource(retrofit: Retrofit) =
        retrofit.create(LaunchRemoteDataSource::class.java)

    @ViewModelScoped
    @Provides
    fun provideLaunchRepository(launchesRemoteDataSource: LaunchRemoteDataSource) =
        LaunchRepository(launchesRemoteDataSource = launchesRemoteDataSource)

    @ViewModelScoped
    @Provides
    fun provideCompanyDetailUseCase(launchRepository: LaunchRepository) =
        GetCompanyDetailUseCase(launchRepository = launchRepository)

    @ViewModelScoped
    @Provides
    fun provideLaunchesUseCase(launchRepository: LaunchRepository) =
        GetLaunchesUseCase(launchRepository = launchRepository)
}