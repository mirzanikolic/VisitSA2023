package com.example.visitsacompose.common.model

import com.example.visitsacompose.R
import com.example.visitsacompose.common.model.enum.SectionEnum
import com.example.visitsacompose.common.model.enum.TourType

data class HomeItemModel(
    val id: Int,
    val name: String,
    val type: String,
    val address: String,
    val averageRating: Double?,
    val price: Int,
    val image: String,
    val city: String,
    val cost: String,
    val isRecommended: Boolean = false,
    val details: String? = null,
    val url: String? = null,
    val isTour: Boolean = false,
    val tourType: TourType? = null
)

fun displayHomeItems(): List<HomeItemModel> {
    return listOf(
        HomeItemModel(
            id = 1,
            name = "Hotel Central",
            type = "hotel",
            address = "Ćumurija 8",
            averageRating = 4.3,
            price = 3,
            image = "Hi",
            city = "Sarajevo",
            cost = "60$",
            isRecommended = true,
            details = "Hotel Central is a charming and centrally located hotel in the heart of Sarajevo. With its warm and welcoming atmosphere, it offers comfortable rooms, equipped with modern amenities, ensuring a pleasant stay for guests. The hotel features a restaurant serving delicious local and international cuisine, a cozy bar, and a 24-hour front desk. Its convenient location allows easy access to major attractions, shopping areas, and cultural sites in the city.",
            url = "https://www.hotelcentral.ba/"
        ))
}
