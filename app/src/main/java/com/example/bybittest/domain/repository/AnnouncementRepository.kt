package com.example.bybittest.domain.repository

import com.example.bybittest.common.Resource
import com.example.bybittest.domain.model.Announcement
import kotlinx.coroutines.flow.Flow

interface AnnouncementRepository {

    fun getAnnouncement(): Flow<Resource<List<Announcement>>>
}