package com.vietth.gapo.presentation.features.detail.model

import android.content.Context
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.presentation.utils.Utils
import java.util.*

data class DetailNewsViewData(
    val id: String,
    val title: String,
    val description: String,
    val thumb: String,
    val publisherName: String,
    val publisherAvatar: String,
    val publishedDate: Date?

) {

    fun getPublisherAndPublishedDate(context: Context): String {
        return when {
            publisherName.isNotEmpty() && publishedDate != null ->
                "$publisherName • ${Utils.parseReleaseDate(context, publishedDate)}"
            publisherName.isNotEmpty() && publishedDate == null -> publisherName
            publisherName.isEmpty() && publishedDate != null -> Utils.parseReleaseDate(
                context,
                publishedDate
            )
            else -> ""
        }
    }
}

fun News.mapToDetailNewsViewData() = DetailNewsViewData(
    id,
    title,
    description.orEmpty(),
    thumb.orEmpty(),
    publisher?.name.orEmpty(),
    publisher?.icon.orEmpty(),
    publishedDate
)

fun List<News>.mapToDetailNewsViewData() = map { it.mapToDetailNewsViewData() }
