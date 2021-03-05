package com.vietth.gapo.data.news

import com.vietth.gapo.core.common.Result
import com.vietth.gapo.core.remote.RemoteExceptionHandler
import com.vietth.gapo.data.news.remote.NewsRemote
import com.vietth.gapo.data.news.remote.model.mapToDomain
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.repository.NewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val newsRemote: NewsRemote,
    private val remoteExceptionHandler: RemoteExceptionHandler
) : NewsRepository {

    override suspend fun fetchNewsFeed(): Result<List<News>> {
        return try {
            val data = newsRemote.fetchNewsFeed()
            Result.Success(data.mapToDomain())
        } catch (e: Exception) {
            Result.Error(remoteExceptionHandler(e))
        }
    }

    override suspend fun fetchNewsDetail(): Result<News> {
        return try {
            val data = newsRemote.fetchNewsDetail()
                ?: return Result.Error(Exception())
            Result.Success(data.mapToDomain())
        } catch (e: Exception) {
            Result.Error(remoteExceptionHandler(e))
        }
    }
}