package com.vietth.gapo.presentation.features.home.model

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.model.NewsType

interface HomeNewsViewData {

    val id: String

    val title: String

    val layoutRes: Int

    fun shallowCopy(): HomeNewsViewData

    fun areContentsTheSame(homeNewsViewData: HomeNewsViewData): Boolean

    object DiffCallback : DiffUtil.ItemCallback<HomeNewsViewData>() {
        override fun areItemsTheSame(
            oldItem: HomeNewsViewData,
            newItem: HomeNewsViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: HomeNewsViewData,
            newItem: HomeNewsViewData
        ): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }
    }

    class LiveData : MutableLiveData<List<HomeNewsViewData>>() {

        override fun setValue(value: List<HomeNewsViewData>) {
            super.setValue(value.map { it.shallowCopy() })
        }

        override fun postValue(value: List<HomeNewsViewData>) {
            super.postValue(value.map { it.shallowCopy() })
        }
    }
}

fun List<News>.mapToHomeNewsViewData(): List<HomeNewsViewData> = map {
    when (it.type) {
        NewsType.LONG_FORM -> it.mapToHomeNewsLongFormViewData()
        NewsType.VIDEO -> it.mapToHomeNewsVideoViewData()
        NewsType.GALLERY -> it.mapToHomeNewsGalleryViewData()
        NewsType.STORY -> it.mapToHomeNewsStoryViewData()
        else -> it.mapToHomeNewsArticleViewData()
    }
}
