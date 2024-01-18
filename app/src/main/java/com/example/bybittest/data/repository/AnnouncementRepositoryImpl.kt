package com.example.bybittest.data.repository

import com.example.bybittest.common.Resource
import com.example.bybittest.data.remote.api.BybitApi
import com.example.bybittest.domain.model.ApiResponse
import com.example.bybittest.domain.repository.AnnouncementRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception

class AnnouncementRepositoryImpl(
    private val api: BybitApi
) : AnnouncementRepository {
    override fun getAnnouncement(): Flow<Resource<ApiResponse>> = flow {
        try {
            emit(Resource.Loading())
            val announcements = api.getAnnouncement().toAnnouncements()
            emit(Resource.Success(announcements))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Error"))
        }
    }
}