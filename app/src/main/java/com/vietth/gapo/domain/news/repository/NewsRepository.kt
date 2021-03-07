package com.vietth.gapo.domain.news.repository

import com.vietth.gapo.core.common.Result
import com.vietth.gapo.domain.news.model.News
import kotlinx.coroutines.flow.Flow


interface NewsRepository {

    fun fetchNewsFeedFlow(): Flow<List<News>>

    suspend fun fetchNewsDetail(): Result<News>

}