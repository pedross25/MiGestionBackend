package com.example.data.repository.albaran

import com.example.routes.albaran.CreateAlbaranParams
import com.example.service.albaran.AlbaranService
import com.example.utils.BaseResponse

class AlbaranRepositoryImpl(
    private val albaranService: AlbaranService
): AlbaranRepository {
    override suspend fun createAlbaran(params: CreateAlbaranParams): BaseResponse<Any> {
        return try {
            val albaran = albaranService.createAlbaran(params)
            if (albaran != null) {
                BaseResponse.SuccessResponse(albaran)
            } else {
                BaseResponse.ErrorResponse("Error al crear el albarán")
            }
        } catch (e: Exception) {
            BaseResponse.ErrorResponse("Error en la creación del albarán: ${e.message}")
        }
    }

    override suspend fun getAll(): BaseResponse<Any> {
        return try {
            val albaranes = albaranService.getAll()
            BaseResponse.SuccessResponse(albaranes)
        } catch (e: Exception) {
            BaseResponse.ErrorResponse("Error al obtener los albaranes: ${e.message}")
        }
    }

}