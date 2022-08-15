package com.example.cleanarchhilt.common.injection

import com.example.cleanarchhilt.home.data.LaunchRemoteDataSource
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
}
