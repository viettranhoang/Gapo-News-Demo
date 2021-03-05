package com.vietth.gapo.domain.news.repository

import com.vietth.gapo.core.common.Result
import com.vietth.gapo.domain.news.model.News


interface NewsRepository {

    suspend fun fetchNewsFeed(): Result<List<News>>

    suspend fun fetchNewsDetail(): Result<News>

}