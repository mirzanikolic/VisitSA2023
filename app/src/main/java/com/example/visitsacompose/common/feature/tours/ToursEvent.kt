package com.example.visitsacompose.common.feature.tours

import com.example.visitsacompose.common.model.HomeItemModel

sealed class ToursEvent {
    object ScreenStarted : ToursEvent()
    data class AttractionsLoaded(val attractions: List<HomeItemModel>) : ToursEvent()
    data class Error(val throwable: Throwable): ToursEvent()
}