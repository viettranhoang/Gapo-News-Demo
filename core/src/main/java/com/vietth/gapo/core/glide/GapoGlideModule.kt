package com.vietth.gapo.core.glide

import android.app.ActivityManager
import android.content.Context
import android.util.Log
import androidx.core.content.getSystemService
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import java.io.InputStream

@GlideModule
class GapoGlideModule : AppGlideModule() {

    private val Context.isHighPerformingDevice: Boolean
        get() {
            val activityManager =
                applicationContext.getSystemService<ActivityManager>() ?: return false
            return !activityManager.isLowRamDevice &&
                    Runtime.getRuntime().availableProcessors() >= 4 &&
                    activityManager.memoryClass >= 128
        }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory())

        val memoryCategory = if (context.isHighPerformingDevice) {
            MemoryCategory.HIGH
        } else {
            MemoryCategory.NORMAL
        }

        glide.setMemoryCategory(memoryCategory)
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        builder.setLogLevel(Log.ERROR)
        val requestOptions = RequestOptions()

        val decodeFormat = if (context.isHighPerformingDevice) {
            DecodeFormat.PREFER_ARGB_8888
        } else {
            DecodeFormat.PREFER_RGB_565
        }
        builder.setDefaultRequestOptions(requestOptions.format(decodeFormat))
    }


    override fun isManifestParsingEnabled(): Boolean = false
}