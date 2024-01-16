package com.example.bybittest.data.remote.api

import com.example.bybittest.data.remote.dto.AnnouncementDto

interface BybitApi {

    suspend fun getAnnouncement(): List<AnnouncementDto>
}