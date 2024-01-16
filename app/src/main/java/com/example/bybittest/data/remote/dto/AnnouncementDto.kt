package com.example.bybittest.data.remote.dto

import com.example.bybittest.domain.model.Announcement

data class AnnouncementDto(
    val title: String,
    val description: String,
    val type: TypeDto,
    val tags: List<String>,
    val url: String,
    val dateTimestamp: Long,
    val startDateTimestamp: Long,
    val endDateTimestamp: Long
) {
    fun toAnnouncement(): Announcement {
        return Announcement(
            title = title,
            description = description,
            type = type,
            tags = tags,
            url = url
        )
    }
}
