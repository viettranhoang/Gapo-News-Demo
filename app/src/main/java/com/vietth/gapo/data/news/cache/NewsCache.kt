package com.vietth.gapo.data.news.cache

import com.vietth.gapo.domain.news.model.News
import kotlinx.coroutines.flow.Flow

interface NewsCache {

    suspend fun saveNews(news: List<News>)

    fun newsFlow(): Flow<List<News>>

}