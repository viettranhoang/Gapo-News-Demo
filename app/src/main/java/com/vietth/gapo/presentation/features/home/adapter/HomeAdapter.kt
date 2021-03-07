package com.vietth.gapo.presentation.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.vietth.gapo.BR
import com.vietth.gapo.R
import com.vietth.gapo.core.extensions.inflateViewDataBinding
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.HomeNewsGalleryItemBinding
import com.vietth.gapo.databinding.HomeNewsVideoItemBinding
import com.vietth.gapo.presentation.features.home.adapter.viewholder.HomeBaseViewHolder
import com.vietth.gapo.presentation.features.home.adapter.viewholder.HomeNewsGalleryViewHolder
import com.vietth.gapo.presentation.features.home.adapter.viewholder.HomeNewsVideoViewHolder
import com.vietth.gapo.presentation.features.home.model.HomeNewsViewData
import com.vietth.gapo.presentation.features.home.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asExecutor

class HomeAdapter(
    private val exoPlayer: SimpleExoPlayer,
    private val homeViewModel: HomeViewModel,
    private val glideRequests: GlideRequests,
    private val dispatcherDefault: CoroutineDispatcher
) : ListAdapter<HomeNewsViewData, HomeBaseViewHolder>(
    AsyncDifferConfig.Builder(HomeNewsViewData.DiffCallback)
        .setBackgroundThreadExecutor(dispatcherDefault.asExecutor())
        .build()
) {

    private val viewPool = RecyclerView.RecycledViewPool()


    init {
        setHasStableIds(true)
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBaseViewHolder {
        val binding = parent.inflateViewDataBinding<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            viewType
        ).apply {
            setVariable(BR.glideRequests, this@HomeAdapter.glideRequests)
            setVariable(
                BR.homeViewModel,
                this@HomeAdapter.homeViewModel
            )
        }
        return when (viewType) {
            R.layout.home_news_video_item -> {
                HomeNewsVideoViewHolder(
                    binding as HomeNewsVideoItemBinding,
                    glideRequests,
                    exoPlayer
                )
            }
            R.layout.home_news_gallery_item -> {
                HomeNewsGalleryViewHolder(
                    binding as HomeNewsGalleryItemBinding,
                    glideRequests,
                    viewPool,
                    dispatcherDefault
                )
            }
            else -> HomeBaseViewHolder(binding, glideRequests)
        }
    }

    override fun onBindViewHolder(holder: HomeBaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id.hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutRes
    }

    override fun onViewRecycled(holder: HomeBaseViewHolder) {
        super.onViewRecycled(holder)
        holder.onViewRecycle()
    }

    override fun onViewAttachedToWindow(holder: HomeBaseViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: HomeBaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onViewDetachedFromWindow()
    }

}

