package com.vietth.gapo.domain.news.model

import java.util.*

data class News(
    val id: String,
    val title: String,
    val description: String? = null,
    val type: NewsType? = null,
    val publishedDate: Date? = null,
    val images: List<String> = emptyList(),
    val content: Content? = null,
    val publisher: Publisher? = null,
    val thumb: String? = null
)