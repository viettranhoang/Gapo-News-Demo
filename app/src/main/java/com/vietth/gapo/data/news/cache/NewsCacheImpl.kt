package com.vietth.gapo.data.news.cache

import com.vietth.gapo.data.news.cache.database.NewsDAO
import com.vietth.gapo.data.news.cache.model.mapToDomain
import com.vietth.gapo.data.news.cache.model.mapToEntity
import com.vietth.gapo.domain.news.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsCacheImpl @Inject constructor(
    private val newsDAO: NewsDAO
): NewsCache {

    override suspend fun saveNews(news: List<News>) {
        newsDAO.insertNews(news.mapToEntity())
    }

    override fun newsFlow(): Flow<List<News>> {
        return newsDAO.newsFlow().map { it.mapToDomain() }
    }

}