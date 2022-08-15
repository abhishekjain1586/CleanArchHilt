package com.example.cleanarchhilt.home.ui.launch

import com.example.cleanarchhilt.home.domain.model.CompanyDetail
import com.example.cleanarchhilt.home.domain.model.Launch


sealed class HomeUiState {
    class Success(
        val name: String?,
        val founder: String?,
        val founded: Int?,
        val employees: Int?,
        val message: String? = null,
        val launches: List<Launch> = listOf(),
    ) : HomeUiState()

    data class Failure(val message: String) : HomeUiState()
    //data class Error(val message: String) : HomeUiState()
    object Loader : HomeUiState()
}

sealed class HomeNavigationState {
    data class LaunchDetail(val url: String, val link: Link) : HomeNavigationState()
}

enum class Link {
    ARTICLE,
    VIDEO,
    WIKIPEDIA
}

fun mapToHomeUiState(companyDetail: CompanyDetail?, launches: List<Launch>) =
    HomeUiState.Success(
        name = companyDetail?.name,
        founder = companyDetail?.founder,
        founded = companyDetail?.founded,
        employees = companyDetail?.employees,
        launches = launches,
    )
