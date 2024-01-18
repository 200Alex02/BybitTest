package com.example.bybittest.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bybittest.common.Resource
import com.example.bybittest.domain.use_case.GetAnnouncementsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    getAnnouncements: GetAnnouncementsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getAnnouncements()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = HomeState(
                            announcement = result.data?.resul?.list ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = HomeState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = HomeState(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }
}