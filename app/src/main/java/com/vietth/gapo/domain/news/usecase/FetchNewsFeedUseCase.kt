package com.vietth.gapo.domain.news.usecase

import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchNewsFeedUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<List<News>> = newsRepository.fetchNewsFeedFlow()

}