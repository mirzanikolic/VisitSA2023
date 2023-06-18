package com.example.visitsacompose.common.feature.home

import com.example.visitsacompose.common.model.HomeItemModel

data class HomeState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val attractions: List<HomeItemModel>
) {
    companion object {
        val initial = HomeState(
            isLoading = false,
            error = null,
            attractions = emptyList()
        )
    }
}



