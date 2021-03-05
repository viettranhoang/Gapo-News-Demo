package com.vietth.gapo.core.common

sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T) : Result<T>()
    class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "DataState is SUCCESS: [data=$data]"
            is Error -> "DataState is ERROR: [exception=$exception]"
        }
    }
}