package com.example.visitsacompose.common.model

import com.example.visitsacompose.common.model.enum.TourType

data class ToursSectionModel(
    val id: Int,
    val title: String,
    val type: TourType
)

fun displayTourSections(): List<ToursSectionModel> {
    return listOf(
        ToursSectionModel(
            id = 1,
            title = "All",
            type = TourType.ALL
        ),
        ToursSectionModel(
            id = 2,
            title = "Popular",
            type = TourType.POPULAR
        ),
        ToursSectionModel(
            id = 3,
            title = "Recommended",
            type = TourType.RECOMMENDED
        )
    )
}
