package com.vietth.gapo.data.news.remote.api

import com.vietth.gapo.data.news.remote.model.NewsDTO
import com.vietth.gapo.data.news.remote.response.FetchNewsFeedResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApiService {

    @GET
    suspend fun fetchNewsFeed(
        @Url url: String,
    ): FetchNewsFeedResponse

    @GET
    suspend fun fetchNewsDetail(
        @Url url: String,
    ): NewsDTO?

}