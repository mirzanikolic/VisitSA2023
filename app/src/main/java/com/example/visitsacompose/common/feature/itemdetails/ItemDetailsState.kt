package com.example.visitsacompose.common.feature.itemdetails

import com.example.visitsacompose.common.model.HomeItemModel

data class ItemDetailsState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val attraction: HomeItemModel
) {
    companion object {
        val initial = ItemDetailsState(
            isLoading = false,
            error = null,
            attraction = HomeItemModel(1, "", "", "", 3.0, 2, "", "", "")
        )
    }
}
