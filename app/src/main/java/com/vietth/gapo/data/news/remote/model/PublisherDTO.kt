package com.vietth.gapo.data.news.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.vietth.gapo.domain.news.model.Publisher

@JsonClass(generateAdapter = true)
data class PublisherDTO(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "icon")
    val icon: String?
)

fun PublisherDTO.mapToDomain() = Publisher(
    id, name, icon
)

fun List<PublisherDTO>.mapToDomain() = map { it.mapToDomain() }
