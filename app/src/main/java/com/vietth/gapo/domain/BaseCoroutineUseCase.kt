package com.vietth.gapo.domain

import com.vietth.gapo.core.common.Result

interface BaseCoroutineUseCase<out T : Any> {

    suspend operator fun invoke(): Result<T>
}