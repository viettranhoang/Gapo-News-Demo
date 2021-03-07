package com.vietth.gapo.presentation.utils

import android.content.Context
import com.vietth.gapo.R
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.*

object Utils {

    fun parseReleaseDate(context: Context, releaseDate: Date?): String {
        if (releaseDate == null) return ""
        val now = LocalDateTime.now()
        val end = releaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        val diffYear = ChronoUnit.YEARS.between(end, now)
        val diffMonth = ChronoUnit.MONTHS.between(end, now)
        val diffDays = ChronoUnit.DAYS.between(end, now)
        val diffHours = ChronoUnit.HOURS.between(end, now)
        val diffMinutes = ChronoUnit.MINUTES.between(end, now)
        return when {
            diffYear > 0 -> {
                context.getString(R.string.years_ago, diffYear)
            }
            diffMonth > 0 -> {
                context.getString(R.string.months_ago, diffMonth)
            }
            diffDays > 0 -> {
                context.getString(R.string.days_ago, diffDays)
            }
            diffHours > 0 -> {
                context.getString(R.string.hours_ago, diffHours)
            }
            else -> {
                context.getString(R.string.minutes_ago, if (diffMinutes > 1) diffMinutes else 1)
            }
        }
    }
}