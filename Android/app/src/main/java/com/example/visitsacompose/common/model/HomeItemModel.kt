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
