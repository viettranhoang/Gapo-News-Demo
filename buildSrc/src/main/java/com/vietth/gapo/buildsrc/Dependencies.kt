package com.vietth.gapo.buildsrc


object Versions {
    const val compileSdkVersion = 29
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
}

object Libs {

    private const val androidGradlePluginVersion = "4.1.2"

    const val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"

    object Modules {
        const val core = ":core"
    }

    object Kotlin {
        private const val version = "1.4.31"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"

        object Coroutines {
            private const val version = "1.4.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
            const val reactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$version"
        }
    }

    object AndroidX {

        object Hilt {
            private const val version = "1.0.0-alpha03"

            const val common = "androidx.hilt:hilt-common:$version"
            const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val work = "androidx.hilt:hilt-work:$version"
            const val navigationFragment = "androidx.hilt:hilt-navigation-fragment:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object Room {
            private const val version = "2.3.0-beta02"

            const val compiler = "androidx.room:room-compiler:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val coreKtx = "androidx.room:room-ktx:$version"
            const val rxjava2 = "androidx.room:room-rxjava2:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val viewModelSavedState =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val process = "androidx.lifecycle:lifecycle-process:$version"
            const val service = "androidx.lifecycle:lifecycle-service:$version"
            const val reactivestreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:$version"

        }

        object Navigation {
            private const val version = "2.3.3"

            const val gradlePlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$version"

            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"

        }

        object WorkManager {
            private const val version = "2.5.0"

            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
            const val rxjava2 = "androidx.work:work-rxjava2:$version"
        }

        object Emoji {
            private const val version = "1.2.0-alpha03"

            const val emoji = "androidx.emoji:emoji:$version"
            const val appcompat = "androidx.emoji:emoji-appcompat:$version"
            const val bundled = "androidx.emoji:emoji-bundled:$version"
            const val google = "com.vanniktech:emoji-google:0.7.0"
        }

        object Leanback {
            const val core = "androidx.leanback:leanback:1.1.0-beta01"
            const val paging = "androidx.leanback:leanback-paging:1.1.0-alpha07"
            const val tabLayout = "androidx.leanback:leanback-tab:1.1.0-beta01"
        }

        const val multidex = "androidx.multidex:multidex:2.0.1"

        const val appCompat = "androidx.appcompat:appcompat:1.3.0-beta01"

        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.0"

        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta01"

        const val activityKtx = "androidx.activity:activity-ktx:1.2.0"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0-alpha2"

        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-beta01"

        const val viewPager2 = "androidx.viewpager2:viewpager2:1.1.0-alpha01"

        const val cardView = "androidx.cardview:cardview:1.0.0"

        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01"

        const val material = "com.google.android.material:material:1.3.0"

        const val dynamicAnimationKtx =
            "androidx.dynamicanimation:dynamicanimation-ktx:1.0.0-alpha03"

        const val localBroadcastManager =
            "androidx.localbroadcastmanager:localbroadcastmanager:1.1.0-alpha01"

        const val browser = "androidx.browser:browser:1.3.0"

        const val exifInterface = "androidx.exifinterface:exifinterface:1.3.2"

        const val startup = "androidx.startup:startup-runtime:1.0.0"

        const val transitionKtx = "androidx.transition:transition-ktx:1.4.0"

        const val security = "androidx.security:security-crypto:1.1.0-alpha03"

        const val paging3 = "androidx.paging:paging-runtime:3.0.0-alpha07"
    }

    object Dagger {
        private const val hiltVersion = "2.33-beta"

        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val rx2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val coroutineAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"

        const val messengerLoggingInterceptor = "com.github.ihsanbal:LoggingInterceptor:3.0.0"
    }

    object OkHttp {
        private const val version = "4.9.0"
        const val core = "com.squareup.okhttp3:okhttp:$version"
        const val tls = "com.squareup.okhttp3:okhttp-tls:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockWebServer = "com.squareup.okhttp:mockwebserver:$version"
    }

    object DeepLink {
        private const val version = "5.2.0"

        const val core = "com.airbnb:deeplinkdispatch:$version"
        const val processor = "com.airbnb:deeplinkdispatch-processor:$version"
    }

    object Glide {
        private const val version = "4.12.0"

        const val core = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
        const val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:$version"
        const val recyclerView = "com.github.bumptech.glide:recyclerview-integration:$version"
        const val transformations = "jp.wasabeef:glide-transformations:4.0.0"
        const val webp = "com.zlc.glide:webpdecoder:2.0.$version"
    }

    object Firebase {
        const val perfGradlePlugin = "com.google.firebase:perf-plugin:1.3.3"
        const val crashlyticsGradlePlugin = "com.google.firebase:firebase-crashlytics-gradle:2.4.1"

        const val bom = "com.google.firebase:firebase-bom:26.1.0"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val remoteConfig = "com.google.firebase:firebase-config-ktx"
        const val messaging = "com.google.firebase:firebase-messaging-ktx"
        const val performance = "com.google.firebase:firebase-perf-ktx"
        const val inAppMessaging = "com.google.firebase:firebase-inappmessaging-display-ktx"
    }

    object GoogleService {
        const val gradlePlugin = "com.google.gms:google-services:4.3.4"

        const val base = "com.google.android.gms:play-services-base:17.5.0"
        const val location = "com.google.android.gms:play-services-location:17.0.0"
        const val ads = "com.google.android.gms:play-services-ads:16.0.0"
        const val auth = "com.google.android.gms:play-services-auth:17.0.0"

    }

    object ReactiveX {
        const val rx2Java = "io.reactivex.rxjava2:rxjava:2.2.20"
        const val rx2Android = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rx2Kotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    }

    object ExoPlayer {
        private const val version = "2.13.1"

        const val exoPlayer = "com.google.android.exoplayer:exoplayer:$version"
        const val core = "com.google.android.exoplayer:exoplayer-core:$version"
        const val dash = "com.google.android.exoplayer:exoplayer-dash:$version"
        const val ui = "com.google.android.exoplayer:exoplayer-ui:$version"
        const val hls = "com.google.android.exoplayer:exoplayer-hls:$version"
        const val smoothStreaming =
            "com.google.android.exoplayer:exoplayer-smoothstreaming:$version"
        const val ima = "com.google.android.exoplayer:extension-ima:$version"
        const val mediasession = "com.google.android.exoplayer:extension-mediasession:$version"
        const val okhttp = "com.google.android.exoplayer:extension-okhttp:$version"
    }

    object MaterialDialogs {
        private const val version = "3.3.0"
        const val core = "com.afollestad.material-dialogs:core:$version"
        const val lifecycle = "com.afollestad.material-dialogs:lifecycle:$version"
    }

    object Moshi {
        private const val version = "1.11.0"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val adapters = "com.squareup.moshi:moshi-adapters:$version"
        const val kotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    const val desugarJDKLibs = "com.android.tools:desugar_jdk_libs:1.1.1"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.6"

    const val toasty = "com.github.GrenderG:Toasty:1.5.0"

    const val autoDimension = "com.github.hantrungkien:AutoDimension:1.0.6"

    const val eventBus = "org.greenrobot:eventbus:3.2.0"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val stateMachine = "com.tinder.statemachine:statemachine:0.2.0"
}