package com.vietth.gapo.data.news.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vietth.gapo.domain.news.model.Content
import com.vietth.gapo.domain.news.model.News

@JsonClass(generateAdapter = true)
data class ContentDTO(
    @Json(name = "href")
    val href: String?,
    @Json(name = "preview_image")
    val previewImage: ImageDTO?,
    @Json(name = "duration")
    val duration: Int?
)

fun ContentDTO.mapToDomain() = Content(
    href.orEmpty(),
    previewImage?.href.orEmpty(),
    duration ?: 0
)

fun List<ContentDTO>.mapToDomain() = map { it.mapToDomain() }
