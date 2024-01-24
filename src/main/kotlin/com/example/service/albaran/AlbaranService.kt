package com.example.service.albaran

import com.example.data.models.Albaran
import com.example.routes.albaran.CreateAlbaranParams

interface AlbaranService {

    suspend fun createAlbaran(params: CreateAlbaranParams): Albaran?

    suspend fun getAll(): List<Albaran>
}