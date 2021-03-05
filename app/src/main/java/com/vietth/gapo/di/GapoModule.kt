package com.vietth.gapo.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vietth.gapo.BuildConfig
import com.vietth.gapo.core.di.qualifier.DebugModeQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GapoModule {

    @Provides
    @Singleton
    @DebugModeQualifier
    fun provideIsDebugMode() = BuildConfig.DEBUG

    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

}