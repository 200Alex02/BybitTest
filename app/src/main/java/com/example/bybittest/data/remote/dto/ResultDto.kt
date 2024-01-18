package com.example.bybittest.data.remote.dto

import com.example.bybittest.domain.model.Result
import kotlinx.serialization.Serializable

@Serializable
data class ResultDto(
    val list: List<AnnouncementDto>,
    val total: Int
) {
    fun toResul(): Result {
        return Result(
            list = list.map { it.toAnnouncement() }
        )
    }
}