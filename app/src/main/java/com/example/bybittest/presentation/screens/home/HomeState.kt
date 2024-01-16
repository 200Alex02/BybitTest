package com.example.bybittest.presentation.screens.home

import com.example.bybittest.domain.model.Announcement

data class HomeState(
    val announcement: List<Announcement> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
