package com.vietth.gapo.data.news.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PublisherDTO(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "icon")
    val icon: String?
)