package com.example.bybittest.data.remote.api

import com.example.bybittest.common.Constants.BASE_URL
import com.example.bybittest.common.Constants.END_POINT
import com.example.bybittest.data.remote.dto.ApiResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class ByBitImpl(private val client: HttpClient): BybitApi {
    override suspend fun getAnnouncement(): ApiResponseDto {
        return client.get { url("${BASE_URL}${END_POINT}") }
    }
}