package com.vietth.gapo.data.news.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.vietth.gapo.data.news.cache.database.NewsConverter
import com.vietth.gapo.domain.news.model.Content
import com.vietth.gapo.domain.news.model.News
import com.vietth.gapo.domain.news.model.NewsType
import com.vietth.gapo.domain.news.model.Publisher
import java.util.*

@Entity(tableName = "news")
@TypeConverters(NewsConverter::class)
data class NewsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "type") val type: NewsType?,
    @ColumnInfo(name = "published_date") val publishedDate: Date?,
    @ColumnInfo(name = "images") val images: List<String>,
    @ColumnInfo(name = "content") val content: Content?,
    @ColumnInfo(name = "publisher") val publisher: Publisher?,
    @ColumnInfo(name = "thumb") val thumb: String?,
)

fun NewsEntity.mapToDomain() =
    News(
        id, title, description, type, publishedDate, images, content, publisher, thumb
    )

fun List<NewsEntity>.mapToDomain() = map { it.mapToDomain() }

fun News.mapToEntity() =
    NewsEntity(
        id,
        title,
        description,
        type,
        publishedDate,
        images,
        content,
        publisher,
        thumb
    )

fun List<News>.mapToEntity() = map { it.mapToEntity() }
