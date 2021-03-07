package com.vietth.gapo.presentation.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.vietth.gapo.R
import com.vietth.gapo.core.glide.GlideRequests

@BindingAdapter(value = ["glideRequests", "imageSrc"])
internal fun ImageView.setImageSrcBinding(
    glideRequests: GlideRequests?,
    imageSrc: String?
) {
    val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.black_alpha_60))
    glideRequests
        ?.asDrawable()
        ?.load(imageSrc)
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

@BindingAdapter(value = ["glideRequests", "newsPublisherAvatar"])
internal fun ImageView.setNewsVideoPreviewBinding(
    glideRequests: GlideRequests?,
    newsPublisherAvatar: String?
) {
    val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.black_alpha_60))
    glideRequests
        ?.asDrawable()
        ?.load(newsPublisherAvatar)
        ?.fallback(colorDrawable)
        ?.placeholder(colorDrawable)
        ?.error("https://storage.googleapis.com/simpletechinvestment/2019/07/2e25a35e-24h_300_200.png")
        ?.centerCrop()
        ?.dontAnimate()
        ?.diskCacheStrategy(DiskCacheStrategy.ALL)
        ?.priority(Priority.IMMEDIATE)
        ?.into(this)
}