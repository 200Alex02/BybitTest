package com.example.bybittest.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TypeDto(
    val key: String,
    val title: String
)