package com.example.bybittest.domain.use_case

import com.example.bybittest.common.Resource
import com.example.bybittest.domain.model.ApiResponse
import com.example.bybittest.domain.repository.AnnouncementRepository
import kotlinx.coroutines.flow.Flow

class GetAnnouncementsUseCase(
    private val repository: AnnouncementRepository
) {
    operator fun invoke(): Flow<Resource<ApiResponse>> {
        return repository.getAnnouncement()
    }
}