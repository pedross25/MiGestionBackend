package com.example.data.repository.albaran

import com.example.routes.albaran.CreateAlbaranParams
import com.example.utils.BaseResponse

interface AlbaranRepository {

    suspend fun createAlbaran(params: CreateAlbaranParams): BaseResponse<Any>

    suspend fun getAll(): BaseResponse<Any>
}