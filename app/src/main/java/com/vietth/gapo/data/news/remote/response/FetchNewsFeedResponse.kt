package com.vietth.gapo.data.news.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vietth.gapo.data.news.remote.model.NewsDTO

@JsonClass(generateAdapter = true)
class FetchNewsFeedResponse(
    @Json(name = "items") val news: List<NewsDTO>?
)