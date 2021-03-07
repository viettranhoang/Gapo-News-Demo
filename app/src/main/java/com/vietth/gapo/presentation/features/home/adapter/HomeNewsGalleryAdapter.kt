package com.vietth.gapo.presentation.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vietth.gapo.core.BR
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.HomeNewsGalleryImageItemBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asExecutor

class HomeNewsGalleryAdapter(
    private val glideRequests: GlideRequests,
    dispatcherDefault: CoroutineDispatcher,
) : ListAdapter<String, HomeNewsGalleryAdapter.HomeNewsGalleryViewHolder>(
    AsyncDifferConfig.Builder(DiffCallback)
        .setBackgroundThreadExecutor(dispatcherDefault.asExecutor())
        .build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewsGalleryViewHolder {
        val binding =
            HomeNewsGalleryImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
                .apply {
                    setVariable(BR.glideRequests, this@HomeNewsGalleryAdapter.glideRequests)
                }
        return HomeNewsGalleryViewHolder(binding, glideRequests)
    }

    override fun onBindViewHolder(holder: HomeNewsGalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeNewsGalleryViewHolder(
        private val binding: HomeNewsGalleryImageItemBinding,
        private val glideRequests: GlideRequests,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.run {
                setVariable(BR.item, item)
                executePendingBindings()
            }
        }

        fun onViewRecycle() {
            glideRequests.clear(binding.imageGallery)
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return false
        }
    }
}