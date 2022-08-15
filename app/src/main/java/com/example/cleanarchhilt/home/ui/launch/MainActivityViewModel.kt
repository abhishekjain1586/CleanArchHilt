package com.example.cleanarchhilt.home.ui.launch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchhilt.common.network.Resource
import com.example.cleanarchhilt.home.domain.model.CompanyDetail
import com.example.cleanarchhilt.home.domain.model.Launch
import com.example.cleanarchhilt.home.domain.usecase.GetCompanyDetailUseCase
import com.example.cleanarchhilt.home.domain.usecase.GetLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val companyDetailUseCase: GetCompanyDetailUseCase,
    private val launchesUseCase: GetLaunchesUseCase
) : ViewModel() {

    val liveDataHomeData = MutableLiveData<HomeUiState>()
    val liveDataNavigation = MutableLiveData<HomeNavigationState>()

    fun fetchData() {
        liveDataHomeData.value = HomeUiState.Loader
        viewModelScope.launch {
            val companyResFlow = async { companyDetailUseCase() }
            val launchesResFlow = async { launchesUseCase() }
            sendResult(
                companyResult = companyResFlow.await(),
                launchResult = launchesResFlow.await()
            )
        }
    }

    private suspend fun sendResult(
        companyResult: Flow<Resource<CompanyDetail>>,
        launchResult: Flow<Resource<List<Launch>>>
    ) {
        var hasData = false
        var companyDetail: CompanyDetail? = null
        var launches: List<Launch> = listOf()

        companyResult.collect {
            when (it) {
                is Resource.Success -> {
                    hasData = true
                    companyDetail = it.data
                }
                is Resource.Failure -> {}
                is Resource.Error -> {}
            }
        }
        launchResult.collect {
            when (it) {
                is Resource.Success -> {
                    hasData = true
                    launches = it.data
                }
                is Resource.Failure -> {}
                is Resource.Error -> {}
            }
        }
        if (hasData) liveDataHomeData.value = mapToHomeUiState(
            companyDetail = companyDetail,
            launches = launches
        )
        Log.d("testingggg", "test")
    }
}
