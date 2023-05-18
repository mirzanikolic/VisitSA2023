package com.example.visitsacompose.common.model

import com.example.visitsacompose.R

data class OnboardingModel(
    val title: String,
    val body: String,
    val image: Int
)

fun displayOnboardingList(): List<OnboardingModel> {
    return listOf(
        OnboardingModel(
            title = "Historical Riches: Unveiling the Architectural Splendor",
            body = "Unlock the hidden gems of your destination",
            image = R.drawable.onboarding_1
        ),
        OnboardingModel(
            title = "Nature's Oasis: Discovering the Breathtaking Scenery",
            body = "Making every moment truly unforgettable",
            image = R.drawable.onboarding_2
        ),
        OnboardingModel(
            title = "Cultural Tapestry: Immersing in the Vibrant Arts and Traditions",
            body = "Ensuring a stress-free travel experience",
            image = R.drawable.onboarding_3
        )
    )
}