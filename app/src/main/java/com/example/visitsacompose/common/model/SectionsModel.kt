package com.example.visitsacompose.common.model

import com.example.visitsacompose.common.model.enum.SectionEnum

data class SectionsModel(
    val id: Int,
    val title: String,
    val type: SectionEnum
)

fun displaySections(): List<SectionsModel> {
    return listOf(
        SectionsModel(
            id = 1,
            title = "Hotels",
            type = SectionEnum.HOTEL
        ),
        SectionsModel(
            id = 2,
            title = "Restaurants",
            type = SectionEnum.RESTAURANT
        ),
        SectionsModel(
            id = 3,
            title = "Clubs",
            type = SectionEnum.CLUB
        ),
        SectionsModel(
            id = 4,
            title = "Tours",
            type = SectionEnum.TOUR
        )
    )
}