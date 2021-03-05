package com.vietth.gapo.data.news.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.model.NewsType
import java.util.*

@JsonClass(generateAdapter = true)
data class NewsDTO(
    @Json(name = "document_id") val documentId: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "content_type") val contentType: NewsType?,
    @Json(name = "published_date") val publishedDate: Date?,
    @Json(name = "publisher") val publisher: PublisherDTO?,
    @Json(name = "origin_url") val originUrl: String?,
    @Json(name = "avatar") val avatar: ImageDTO?,
    @Json(name = "images") val images: List<ImageDTO>?,
    @Json(name = "content") val content: ContentDTO?
)


fun NewsDTO.mapToDomain() = News(
    documentId.orEmpty(),
    title.orEmpty(),
    description,
    contentType,
    publishedDate,
    images?.map { it.href.orEmpty() }  ?: emptyList(),
    content?.mapToDomain()
)

fun List<NewsDTO>.mapToDomain() = map { it.mapToDomain() }
