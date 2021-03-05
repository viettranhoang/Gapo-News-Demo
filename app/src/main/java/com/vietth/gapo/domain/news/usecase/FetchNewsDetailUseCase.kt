package com.vietth.gapo.domain.news.usecase

import com.vietth.gapo.core.common.Result
import com.vietth.gapo.domain.BaseCoroutineUseCase
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.repository.NewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchNewsDetailUseCase @Inject constructor(private val newsRepository: NewsRepository) :
    BaseCoroutineUseCase<News> {

    override suspend fun invoke(): Result<News> =
        newsRepository.fetchNewsDetail()

}