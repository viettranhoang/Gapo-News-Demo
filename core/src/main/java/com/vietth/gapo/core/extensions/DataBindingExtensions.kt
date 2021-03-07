@file:JvmName("DataBindingExtensions")

package com.vietth.gapo.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

inline fun <reified T : ViewDataBinding> ViewGroup.inflateViewDataBinding(
    layoutInflater: LayoutInflater,
    @LayoutRes layout: Int
): T =
    DataBindingUtil.inflate<T>(
        layoutInflater,
        layout,
        this,
        false
    )

@set:BindingAdapter("isVisible")
inline var View.isVisible: Boolean?
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value == true) View.VISIBLE else View.GONE
    }

@set:BindingAdapter("isInvisible")
inline var View.isInvisible: Boolean?
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value == true) View.INVISIBLE else View.VISIBLE
    }

@BindingAdapter("submitList")
fun <T> RecyclerView.setDataBinding(data: List<T>?) {
    @Suppress("UNCHECKED_CAST")
    (adapter as? ListAdapter<T, *>)?.submitList(data)
}

@BindingAdapter("submitList")
fun <T> ViewPager2.setDataBinding(data: List<T>?) {
    @Suppress("UNCHECKED_CAST")
    (adapter as? ListAdapter<T, *>)?.submitList(data)
}

@BindingAdapter("isSelected")
fun View.setSelectedBinding(selected: Boolean) {
    this.isSelected = selected
}