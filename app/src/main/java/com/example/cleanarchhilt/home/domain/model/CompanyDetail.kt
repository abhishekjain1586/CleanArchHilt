package com.example.cleanarchhilt.home.domain.model

data class CompanyDetail(
    val name: String?,
    val founder: String?,
    val founded: Int?,
    val employees: Int?,
    val valuation: Long?,
    val headquarters: Headquarters?,
)

data class Headquarters(
    val address: String?,
    val city: String?,
    val state: String?,
)
