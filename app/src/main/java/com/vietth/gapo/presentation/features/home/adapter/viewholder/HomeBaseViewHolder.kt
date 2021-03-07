package com.vietth.gapo.presentation.features.home.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.vietth.gapo.BR
import com.vietth.gapo.core.glide.GlideRequests
import com.vietth.gapo.presentation.features.home.model.HomeNewsViewData

open class HomeBaseViewHolder(
    private val binding: ViewDataBinding,
    private val glideRequests: GlideRequests,
) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(item: HomeNewsViewData) {
        binding.run {
            setVariable(BR.item, item)
            executePendingBindings()
        }
    }

    open fun onViewRecycle() {

    }

    open fun onViewAttachedToWindow() {
    }

    open fun onViewDetachedFromWindow() {
    }
}