package com.vietth.gapo.data.news.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vietth.gapo.data.news.cache.model.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertNews(news: List<NewsEntity>)

    @Query("SELECT * FROM news")
    abstract fun newsFlow(): Flow<List<NewsEntity>>


}