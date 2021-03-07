package com.vietth.gapo.presentation.features.home.adapter.viewholder

import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.vietth.gapo.R
import com.vietth.gapo.core.extensions.isVisible
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.HomeNewsVideoItemBinding
import com.vietth.gapo.presentation.features.home.model.HomeNewsVideoViewData
import com.vietth.gapo.presentation.features.home.model.HomeNewsViewData


class HomeNewsVideoViewHolder(
    private val binding: HomeNewsVideoItemBinding,
    private val glideRequests: GlideRequests,
    private val exoPlayer: SimpleExoPlayer
) : HomeBaseViewHolder(binding, glideRequests) {

    private val playButtonResource: Int
        get() = if (!exoPlayer.playWhenReady) R.drawable.ic_play_circle_filled else R.drawable.ic_pause_circle_filled

    init {
        binding.viewPlayer.apply {
            player = exoPlayer
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH
            useController = false
            setControllerVisibilityListener {
                binding.buttonPlay.visibility = it
            }
        }

        binding.buttonPlay.setOnClickListener {
            binding.imagePreview.isVisible = false
            exoPlayer.playWhenReady = !exoPlayer.playWhenReady
        }

        exoPlayer.addListener(object : Player.EventListener {
            override fun onIsPlayingChanged(isPlaying: Boolean) {
                binding.buttonPlay.setImageResource(playButtonResource)
            }
        })
    }

    override fun bind(item: HomeNewsViewData) {
        super.bind(item)
        if (item !is HomeNewsVideoViewData) return
        exoPlayer.clearMediaItems()
        val mediaItem: MediaItem = MediaItem.fromUri(item.videoSource)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
    }

    override fun onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow()
        exoPlayer.pause()
    }

    override fun onViewRecycle() {
        super.onViewRecycle()
        exoPlayer.stop()
        glideRequests.clear(binding.imagePreview)
        glideRequests.clear(binding.imagePublisher)
    }
}