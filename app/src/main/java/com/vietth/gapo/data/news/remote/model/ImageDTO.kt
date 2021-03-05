package com.vietth.gapo.data.news.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDTO(
    @Json(name = "href")
    val href: String?,
    @Json(name = "main_color")
    val mainColor: String?,
    @Json(name = "width")
    val width: Int?,
    @Json(name = "height")
    val height: Int?
)