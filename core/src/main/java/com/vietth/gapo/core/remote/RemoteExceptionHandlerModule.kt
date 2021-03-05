package com.vietth.gapo.core.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteExceptionHandlerModule {

    @Binds
    @Singleton
    internal abstract fun bindExceptionHandler(exceptionHandler: RemoteExceptionHandlerImpl): RemoteExceptionHandler
}

interface RemoteExceptionHandler {

    operator fun invoke(exception: Exception): Exception
}

@Singleton
internal class RemoteExceptionHandlerImpl @Inject constructor(
    moshi: Moshi
) : RemoteExceptionHandler {

    private val moshiAdapter = moshi.adapter(RemoteErrorMessage::class.java)

    override fun invoke(exception: Exception): Exception {
        return when (exception) {
            is HttpException -> {
                var code = exception.code()
                var message = exception.message()
                val errorBody = exception.response()?.errorBody()?.string()
                if (!errorBody.isNullOrEmpty()) {
                    try {
                        val data = moshiAdapter.fromJson(errorBody)
                        if (data?.code != null && !data.message.isNullOrEmpty()) {
                            code = data.code
                            message = data.message
                        }
                    } catch (_: Exception) {
                    }
                }
                when (code) {
                    404 -> RemoteDataNotFoundException(message)
                    else -> RemoteUnknownException(message)
                }
            }
            is ConnectException, is UnknownHostException, is SocketTimeoutException -> ConnectException()
            else -> exception
        }
    }
}

internal class RemoteDataNotFoundException(message: String? = "") : Exception(message.orEmpty())
internal class RemoteUnknownException(message: String? = "") : Exception(message.orEmpty())

@JsonClass(generateAdapter = true)
internal data class RemoteErrorMessage(
    @Json(name = "code") val code: Int?,
    @Json(name = "message") val message: String?
)