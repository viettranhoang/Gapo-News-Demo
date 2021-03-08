package com.vietth.gapo.data.news

import com.vietth.gapo.core.common.Result
import com.vietth.gapo.core.remote.RemoteExceptionHandler
import com.vietth.gapo.data.news.cache.NewsCache
import com.vietth.gapo.data.news.remote.NewsRemote
import com.vietth.gapo.data.news.remote.model.mapToDomain
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.repository.NewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val newsCache: NewsCache,
    private val newsRemote: NewsRemote,
    private val remoteExceptionHandler: RemoteExceptionHandler
) : NewsRepository {

    /**
     * Sử dụng flow để merge các DataSources
     * Request data song song từ các DataSources
     * Nếu nhận được dữ liệu từ Remote sẽ lưu xuống Cache trước khi emit.
     */
    @ExperimentalCoroutinesApi
    override fun fetchNewsFeedFlow(): Flow<List<News>> {
        val cacheFlow = newsCache.newsFlow()

        val remoteFlow = flow {
            val data = newsRemote.fetchNewsFeed().mapToDomain()
            newsCache.saveNews(data)
            emit(data)
        }.catch {
            Timber.e(it)
        }
        return merge(cacheFlow, remoteFlow)
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