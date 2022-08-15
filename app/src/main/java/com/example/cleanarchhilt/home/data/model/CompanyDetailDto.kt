package com.example.cleanarchhilt.home.data.model

data class CompanyDetailDto(
    val name: String?,
    val founder: String?,
    val founded: Int?,
    val employees: Int?,
    val valuation: Long?,
    val headquarters: HeadquartersDto?,
)

data class HeadquartersDto(
    val address: String?,
    val city: String?,
    val state: String?,
)