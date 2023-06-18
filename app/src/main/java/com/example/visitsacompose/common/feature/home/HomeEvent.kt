package com.example.visitsacompose.common.feature.home

import com.example.visitsacompose.common.model.HomeItemModel

sealed class HomeEvent {
    object ScreenStarted : HomeEvent()
    data class AttractionsLoaded(val attractions: List<HomeItemModel>) : HomeEvent()
    data class Error(val throwable: Throwable): HomeEvent()
}