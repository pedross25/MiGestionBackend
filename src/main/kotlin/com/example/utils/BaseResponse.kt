package com.example.utils

import io.ktor.http.*

sealed class BaseResponse<T>(
    open val statusCode: HttpStatusCode
) {
    data class SuccessResponse<T>(
        val data: T? = null,
        val message: String? = null,
        override val statusCode: HttpStatusCode = HttpStatusCode.OK
    ): BaseResponse<T>(statusCode)

    data class ErrorResponse<T>(
        val exception: T? = null,
        val message: String? = null,
        override val statusCode: HttpStatusCode = HttpStatusCode.BadRequest
    ): BaseResponse<T>(statusCode)
}