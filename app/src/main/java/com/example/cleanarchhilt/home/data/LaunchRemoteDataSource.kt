package com.example.cleanarchhilt.home.data

import com.example.cleanarchhilt.home.data.model.CompanyDetailDto
import com.example.cleanarchhilt.home.data.model.LaunchDto
import retrofit2.Response
import retrofit2.http.GET

interface LaunchRemoteDataSource {
    @GET("v3/info")
    suspend fun getCompanyDetail(): Response<CompanyDetailDto>

    @GET("v3/launches")
    suspend fun getLaunches(): Response<List<LaunchDto>>
}