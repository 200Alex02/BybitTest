package com.example.bybittest.domain.model

import com.example.bybittest.data.remote.dto.TypeDto

data class Announcement(
    val title: String,
    val description: String,
    val type: TypeDto,
    val tags: List<String>,
    val url: String
)
