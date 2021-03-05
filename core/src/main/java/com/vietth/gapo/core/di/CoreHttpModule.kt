package com.vietth.gapo.core.di

import com.vietth.gapo.core.di.qualifier.DebugModeQualifier
import com.vietth.gapo.core.di.qualifier.OkHttpRESTfulQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreHttpModule {

    @Provides
    @Singleton
    @OkHttpRESTfulQualifier
    internal fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        })
        .retryOnConnectionFailure(true)
        .build()

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(
        @DebugModeQualifier isDebug: Boolean
    ): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = if (isDebug) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
}