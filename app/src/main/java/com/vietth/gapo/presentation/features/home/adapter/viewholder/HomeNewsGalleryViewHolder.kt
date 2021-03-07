package com.vietth.gapo.presentation.features.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.databinding.HomeNewsGalleryItemBinding
import com.vietth.gapo.presentation.features.home.adapter.HomeNewsGalleryAdapter
import com.vietth.gapo.presentation.features.home.model.HomeNewsGalleryViewData
import com.vietth.gapo.presentation.features.home.model.HomeNewsViewData
import kotlinx.coroutines.CoroutineDispatcher


class HomeNewsGalleryViewHolder(
    private val binding: HomeNewsGalleryItemBinding,
    private val glideRequests: GlideRequests,
    private val viewPool: RecyclerView.RecycledViewPool,
    private val dispatcherDefault: CoroutineDispatcher
) : HomeBaseViewHolder(binding, glideRequests) {

    private var item: HomeNewsGalleryViewData? = null

    init {
        binding.viewPager.apply {
            adapter = HomeNewsGalleryAdapter(glideRequests, dispatcherDefault)
            binding.indicatorGallery.attachToPager(this)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.textNumber.text = "${position + 1}/${item?.images?.size}"
                }
            })
        }

    }

    override fun bind(item: HomeNewsViewData) {
        super.bind(item)
        if (item !is HomeNewsGalleryViewData) return
        this.item = item

    }

    override fun onViewRecycle() {
        super.onViewRecycle()
        glideRequests.clear(binding.imagePublisher)
    }
}