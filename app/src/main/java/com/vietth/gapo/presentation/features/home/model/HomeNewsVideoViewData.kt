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

data class HomeNewsVideoViewData(
    override val id: String,
    override val title: String,
    val publisherName: String,
    val publisherAvatar: String,
    val videoSource: String,
    val videoDuration: Int?,
    val videoPreviewImage: String,
    val publishedDate: Date?

) : HomeNewsViewData {

    override val layoutRes: Int = R.layout.home_news_video_item

    override fun shallowCopy(): HomeNewsViewData = copy()

    override fun areContentsTheSame(news: HomeNewsViewData): Boolean {
        return if (news !is HomeNewsVideoViewData) false
        else title == news.title && videoSource == news.videoSource
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

fun News.mapToHomeNewsVideoViewData() = HomeNewsVideoViewData(
    id,
    title,
    publisher?.name.orEmpty(),
    publisher?.icon.orEmpty(),
    content?.href.orEmpty(),
    content?.duration,
    content?.previewImage.orEmpty(),
    publishedDate
)

fun List<News>.mapToHomeNewsVideoViewData() = map { it.mapToHomeNewsVideoViewData() }


@BindingAdapter(value = ["glideRequests", "newsVideoPreview"])
internal fun ImageView.setNewsVideoPreviewBinding(
    glideRequests: GlideRequests?,
    newsVideoPreview: String?
) {
    val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.black_alpha_60))
    glideRequests
        ?.asDrawable()
        ?.load(newsVideoPreview)
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