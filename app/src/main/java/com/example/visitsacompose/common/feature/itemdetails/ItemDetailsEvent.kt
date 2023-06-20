package com.example.visitsacompose.common.feature.itemdetails

import com.example.visitsacompose.common.model.HomeItemModel

sealed class ItemDetailsEvent {
    object ScreenStarted : ItemDetailsEvent()
    data class AttractionLoaded(val attraction: HomeItemModel) : ItemDetailsEvent()
    data class Error(val throwable: Throwable): ItemDetailsEvent()
}