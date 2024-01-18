package com.example.bybittest.data.remote.api

import com.example.bybittest.data.remote.dto.ApiResponseDto

interface BybitApi {

    suspend fun getAnnouncement(): ApiResponseDto
}