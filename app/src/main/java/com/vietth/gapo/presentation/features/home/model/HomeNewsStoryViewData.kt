package com.vietth.gapo.presentation.features.home.model

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.vietth.gapo.R
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.presentation.utils.Utils
import java.util.*

data class HomeNewsStoryViewData(
    override val id: String,
    override val title: String,
    val thumb: String,
    val publisherName: String,
    val publisherAvatar: String,
    val publishedDate: Date?,
    val images: List<String>
) : HomeNewsViewData {

    override val layoutRes: Int = R.layout.home_news_story_item

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

fun News.mapToHomeNewsStoryViewData() = HomeNewsStoryViewData(
    id,
    title,
    thumb.orEmpty(),
    publisher?.name.orEmpty(),
    publisher?.icon.orEmpty(),
    publishedDate,
    images
)

fun List<News>.mapToHomeNewsStoryViewData() = map { it.mapToHomeNewsStoryViewData() }

@BindingAdapter(value = ["glideRequests", "newsStory"])
internal fun ImageView.setNewsStoryBinding(
    glideRequests: GlideRequests?,
    newsStory: String?
) {
    val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.black_alpha_60))
    glideRequests
        ?.asDrawable()
        ?.load(newsStory)
        ?.fallback(colorDrawable)
        ?.placeholder(colorDrawable)
        ?.error(colorDrawable)
        ?.centerCrop()
        ?.dontAnimate()
        ?.error(ColorDrawable(Color.GRAY))
        ?.diskCacheStrategy(DiskCacheStrategy.ALL)
        ?.priority(Priority.IMMEDIATE)
        ?.into(this)
}