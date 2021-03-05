package com.vietth.gapo.data.news.remote

import com.vietth.gapo.data.news.remote.model.NewsDTO

interface NewsRemote {
    suspend fun fetchNewsFeed(): List<NewsDTO>

    suspend fun fetchNewsDetail(): NewsDTO?

}