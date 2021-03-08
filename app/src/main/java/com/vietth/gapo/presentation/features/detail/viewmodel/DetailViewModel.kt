package com.vietth.gapo.presentation.features.detail.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.vietth.gapo.core.common.AppCoroutineDispatchers
import com.vietth.gapo.core.common.Result
import com.vietth.gapo.domain.news.usecase.FetchNewsDetailUseCase
import com.vietth.gapo.presentation.features.detail.model.DetailNewsViewData
import com.vietth.gapo.presentation.features.detail.model.mapToDetailNewsViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    application: Application,
    private val savedStateHandle: SavedStateHandle,
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
    private val fetchNewsDetailUseCase: FetchNewsDetailUseCase,
) : ViewModel() {

    val detailNewsLiveData: LiveData<DetailNewsViewData>
        get() = _detailNewsLiveData
    private val _detailNewsLiveData = MutableLiveData<DetailNewsViewData>()

    fun fetchData() {
        viewModelScope.launch {
            val result = withContext(appCoroutineDispatchers.io) {
                fetchNewsDetailUseCase()
            }

            when (result) {
                is Result.Success -> {
                    val news = result.data.mapToDetailNewsViewData()
                    _detailNewsLiveData.value = news
                }
                is Result.Error -> {
                    Timber.e(result.exception, "FetchNewsDetailUseCase")
                }
            }
        }
    }

    fun onClickBack(view: View) {
        view.findNavController().navigateUp()
    }
}