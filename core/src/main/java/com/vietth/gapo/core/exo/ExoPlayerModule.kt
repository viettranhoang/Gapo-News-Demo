package com.vietth.gapo.core.exo

import android.content.Context
import com.google.android.exoplayer2.SimpleExoPlayer
import com.vietth.gapo.core.di.qualifier.OkHttpExoQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExoPlayerModule {

    @Provides
    @Singleton
    @OkHttpExoQualifier
    internal fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideExoPlayer(
        @ApplicationContext context: Context
    ) = SimpleExoPlayer.Builder(context).build()
}