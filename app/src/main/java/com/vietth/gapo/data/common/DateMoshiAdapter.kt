package com.vietth.gapo.data.common

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateMoshiAdapter {

    @FromJson
    fun fromJson(date: String?): Date? {
        if (date == null) return null
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return try {
            formatter.parse(date)
        } catch (e: ParseException) {
            null
        }
    }

    @ToJson
    fun toJson(date: Date?): String? {
        if (date == null) return null
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return formatter.format(date)
    }
}