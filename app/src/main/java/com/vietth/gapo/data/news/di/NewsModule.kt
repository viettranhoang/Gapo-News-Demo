package com.vietth.gapo.data.news.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.vietth.gapo.core.di.qualifier.OkHttpRESTfulQualifier
import com.vietth.gapo.data.common.DataConstants
import com.vietth.gapo.data.news.NewsRepositoryImpl
import com.vietth.gapo.data.news.cache.NewsCache
import com.vietth.gapo.data.news.cache.NewsCacheImpl
import com.vietth.gapo.data.news.cache.database.NewsDAO
import com.vietth.gapo.data.news.cache.database.NewsDatabase
import com.vietth.gapo.data.news.remote.NewsRemote
import com.vietth.gapo.data.news.remote.NewsRemoteImpl
import com.vietth.gapo.data.news.remote.api.NewsApiService
import com.vietth.gapo.domain.news.repository.NewsRepository
import dagger.Binds
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NewsModule {

    @Binds
    @Singleton
    internal abstract fun bindNewsRemote(newsRemote: NewsRemoteImpl): NewsRemote

    @Binds
    @Singleton
    internal abstract fun bindNewsCache(newsCache: NewsCacheImpl): NewsCache

    @Binds
    @Singleton
    internal abstract fun bindNewsRepository(repository: NewsRepositoryImpl): NewsRepository

    companion object {

        @Provides
        @Singleton
        internal fun provideNewsApiService(
            @OkHttpRESTfulQualifier client: Lazy<OkHttpClient>,
            moshi: Moshi
        ) = Retrofit.Builder()
            .baseUrl(DataConstants.LOCAL_HOST)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client.get())
            .build()
            .create(NewsApiService::class.java)

        @Provides
        @Singleton
        fun provideNewsMenuDAO(
            @ApplicationContext context: Context
        ): NewsDAO {
            return NewsDatabase.getInstance(context).newsDAO()
        }
    }
}