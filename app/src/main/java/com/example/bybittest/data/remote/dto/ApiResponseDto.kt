package com.example.bybittest.data.remote.dto

import com.example.bybittest.domain.model.ApiResponse
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseDto(
    val result: ResultDto,
    val retCode: Int,
    val retExtInfo: RetExtInfoDto,
    val retMsg: String,
    val time: Long
) {
    fun toAnnouncements(): ApiResponse {
        return ApiResponse(
            resul = result.toResul()
        )
    }
}