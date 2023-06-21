package com.example.visitsacompose.common.feature.tours

import com.example.visitsacompose.common.model.HomeItemModel

data class ToursState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val attractions: List<HomeItemModel>
) {
    companion object {
        val initial = ToursState(
            isLoading = false,
            error = null,
            attractions = emptyList()
        )
    }
}


