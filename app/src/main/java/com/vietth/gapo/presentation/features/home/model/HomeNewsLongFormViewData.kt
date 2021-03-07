package com.vietth.gapo.presentation.features.home.model

import android.content.Context
import com.vietth.gapo.R
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.presentation.utils.Utils
import java.util.*

data class HomeNewsLongFormViewData(
    override val id: String,
    override val title: String,
    val description: String,
    val thumb: String,
    val publisherName: String,
    val publisherAvatar: String,
    val publishedDate: Date?

) : HomeNewsViewData {

    override val layoutRes: Int = R.layout.home_news_long_form_item

    override fun shallowCopy(): HomeNewsViewData = copy()

    override fun areContentsTheSame(news: HomeNewsViewData): Boolean {
        return if (news !is HomeNewsArticleViewData) false
        else title == news.title
    }

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

fun News.mapToHomeNewsLongFormViewData() = HomeNewsLongFormViewData(
    id,
    title,
    description.orEmpty(),
    thumb ?: images.getOrNull(0).orEmpty(),
    publisher?.name.orEmpty(),
    publisher?.icon.orEmpty(),
    publishedDate
)

fun List<News>.mapToHomeNewsLongFormViewData() = map { it.mapToHomeNewsLongFormViewData() }
