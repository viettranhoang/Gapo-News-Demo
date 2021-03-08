# Gapo-News-Demo

An app which attempts to use the latest cutting edge libraries and tools.

[Demo App download](https://drive.google.com/file/d/1dGdNUB9IF3MLOscXcP0yjvIiCHHZl0hs/view?usp=sharing)

![gapo-demo](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/demo/gapo-news-demo-screenshot.png?raw=true)

## Architecture

* Modularization by feature.
* Clean Architecture + MVVM.
* Dependency injection with Dagger Hilt.

## Android Development

* [Kotlin](https://github.com/JetBrains/kotlin)
* [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* [Dagger Hilt](https://dagger.dev/hilt/)
* [Jetpack Foundation & UI](https://developer.android.com/jetpack): AndroidX, Material Design, ConstrainsLayout,...
* [JetPack Architecture](https://developer.android.com/jetpack): DataBinding, ViewModel, LiveData, Lifecycle, Navigation
* [Retrofit2](https://github.com/square/retrofit)
* [Moshi](https://github.com/square/moshi/)
* [Glide4](https://github.com/bumptech/glide)
* [ExoPlayer2](https://github.com/google/ExoPlayer)
* [Auto Dimension](https://github.com/hantrungkien/AutoDimension)

## Use Case

* Instagram/Youtube style navigation using Navigation Component with [One Activity-Multi Fragment](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/presentation/HostActivity.kt).

* [News feeds](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/presentation/features/home/HomeFragment.kt) with [multiple types](https://github.com/viettranhoang/Gapo-News-Demo/tree/development/app/src/main/java/com/vietth/gapo/presentation/features/home/model) (Gallery + Story + Article + Long From + Video) is smooth scroll.

* Using [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) to [load News Feeds](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/data/news/NewsRepositoryImpl.kt) from multiple data sources.([Cache](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/data/news/cache/NewsCache.kt) and [Remote](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/data/news/remote/NewsRemote.kt)). Each time data is successfully loaded from the [remote](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/data/news/remote/api/NewsApiService.kt) then it will be saved in [local cache](https://github.com/viettranhoang/Gapo-News-Demo/blob/development/app/src/main/java/com/vietth/gapo/data/news/cache/database/NewsDatabase.kt).

## NOT IMPLEMENTED YET

* Deep dive into dealing ExoPlayer in RecyclerView.
* Deep dive into Glide optimization.

### LICENCE

    Copyright 2021 Tran Hoang Viet

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
