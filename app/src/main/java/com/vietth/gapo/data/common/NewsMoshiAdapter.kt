package com.vietth.gapo.data.common

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.vietth.gapo.domain.news.model.NewsType

object NewsMoshiAdapter {

    @FromJson
    fun newsTypeFromJson(key: String?): NewsType? {
        return NewsType.values().find { it.type == key }
    }

    @ToJson
    fun mediaTypeToJson(data: NewsType?): String? {
        return data?.type
    }
}