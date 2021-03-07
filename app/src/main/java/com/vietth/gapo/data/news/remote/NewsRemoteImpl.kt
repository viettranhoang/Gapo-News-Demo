package com.vietth.gapo.data.news.remote

import com.vietth.gapo.data.news.remote.api.NewsApiService
import com.vietth.gapo.data.news.remote.model.NewsDTO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRemoteImpl @Inject constructor(
    private val newsApiService: NewsApiService
): NewsRemote{

    override suspend fun fetchNewsFeed(): List<NewsDTO> {
        // Url + EndPoint => encrypt dưới C
        val url = "https://raw.githubusercontent.com/Akaizz/static/master/newsfeed.json"

        return newsApiService.fetchNewsFeed(url).news.orEmpty().shuffled()
    }

    override suspend fun fetchNewsDetail(): NewsDTO? {
        // Url + EndPoint => encrypt dưới C
        val url = "https://raw.githubusercontent.com/Akaizz/static/master/detail.json"

        return newsApiService.fetchNewsDetail(url)
    }
}