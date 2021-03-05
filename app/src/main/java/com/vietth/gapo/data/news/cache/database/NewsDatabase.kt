package com.vietth.gapo.data.news.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vietth.gapo.data.news.cache.model.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDAO(): NewsDAO

    companion object {

        private const val DATABASE_NAME = "gapo-news-db"

        @Volatile
        private var instance: NewsDatabase? = null

        fun getInstance(
            context: Context
        ): NewsDatabase {
            return instance
                ?: synchronized(this) {
                    instance ?: buildDatabase(context)
                        .also { instance = it }
                }
        }

        private fun buildDatabase(
            context: Context,
        ): NewsDatabase {
            return Room.databaseBuilder(
                context,
                NewsDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}