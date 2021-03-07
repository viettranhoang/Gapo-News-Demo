package com.vietth.gapo.data.news.cache.database

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vietth.gapo.domain.news.model.Content
import com.vietth.gapo.domain.news.model.NewsType
import com.vietth.gapo.domain.news.model.Publisher
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object NewsConverter {

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val imagesType = Types.newParameterizedType(List::class.java, String::class.java)


    @TypeConverter
    fun newsTypeToString(type: NewsType): String {
        return type.type
    }

    @TypeConverter
    fun typeStringToNewsType(type: String): NewsType {
        return NewsType.getByType(type)
    }

    @TypeConverter
    fun fromContent(content: Content?): String {
        val jsonAdapter = moshi.adapter(Content::class.java)
        return jsonAdapter.toJson(content)
    }

    @TypeConverter
    fun toContent(json: String): Content? {
        val jsonAdapter = moshi.adapter(Content::class.java)
        return try {
            jsonAdapter.fromJson(json)
        } catch (e: IOException) {
            null
        }
    }

    @TypeConverter
    fun fromPublisher(publisher: Publisher?): String {
        val jsonAdapter = moshi.adapter(Publisher::class.java)
        return jsonAdapter.toJson(publisher)
    }

    @TypeConverter
    fun toPublisher(json: String): Publisher? {
        val jsonAdapter = moshi.adapter(Publisher::class.java)
        return try {
            jsonAdapter.fromJson(json)
        } catch (e: IOException) {
            null
        }
    }

    @TypeConverter
    fun fromImages(images: List<String>): String {
        val jsonAdapter = moshi.adapter<List<String>>(imagesType)

        return jsonAdapter.toJson(images)
    }

    @TypeConverter
    fun toImages(json: String): List<String> {
        val jsonAdapter = moshi.adapter<List<String>>(imagesType)

        return try {
            jsonAdapter.fromJson(json).orEmpty()
        } catch (e: IOException) {
            emptyList()
        }
    }

    @TypeConverter
    fun toDate(date: String?): Date? {
        if (date == null) return null
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return try {
            formatter.parse(date)
        } catch (e: ParseException) {
            null
        }
    }

    @TypeConverter
    fun fromDate(date: Date?): String? {
        if (date == null) return null
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return formatter.format(date)
    }
}