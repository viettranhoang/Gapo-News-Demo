package com.vietth.gapo.presentation.features.home.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.vietth.gapo.core.common.AppCoroutineDispatchers
import com.vietth.gapo.domain.news.usecase.FetchNewsFeedUseCase
import com.vietth.gapo.presentation.features.home.model.HomeNewsViewData
import com.vietth.gapo.presentation.features.home.model.mapToHomeNewsViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val savedStateHandle: SavedStateHandle,
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
    private val fetchNewsFeedUseCase: FetchNewsFeedUseCase,
) : ViewModel() {

    val homeNewsViewData: LiveData<List<HomeNewsViewData>> = fetchNewsFeedUseCase()
        .flowOn(appCoroutineDispatchers.io)
        .filter { it.isNotEmpty() }
        .map { it.mapToHomeNewsViewData() }
        .catch { e ->
            Timber.e(e, "fetchNewsFeedUseCase")
        }
        .asLiveData(viewModelScope.coroutineContext)

//    val homeNewsViewData: LiveData<List<HomeNewsViewData>>
//        get() = _homeNewsViewData
//    private val _homeNewsViewData = MutableLiveData<List<HomeNewsViewData>>()
//
//    fun fetchData() {
//        viewModelScope.launch {
//            val result = withContext(appCoroutineDispatchers.io) {
//                fetchNewsFeedUseCase()
//            }
//
//            when(result) {
//                is Result.Success -> {
//                    val news = result.data.mapToHomeNewsViewData()
//                    _homeNewsViewData.value = news
//                }
//                is Result.Error -> {
//                    Timber.e(result.exception, "fetchNewsFeedUseCase")
//                }
//            }
//        }
//    }
}