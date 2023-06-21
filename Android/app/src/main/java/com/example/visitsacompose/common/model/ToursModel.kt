package com.example.visitsacompose.common.model

import com.example.visitsacompose.R
import com.example.visitsacompose.common.model.enum.SectionEnum
import com.example.visitsacompose.common.model.enum.TourType

data class ToursModel(
    val id: Int,
    val title: String,
    val type: TourType,
    val rating: Double,
    val price: Int,
    val image: Int,
    val city: String,
    val cost: String,
    val details: String? = null,
    val url: String? = null
)

fun displayTours(): List<ToursModel> {
    return listOf(
        ToursModel(
            id = 19,
            title = "Historical Heritage Walk",
            type = TourType.POPULAR,
            rating = 4.6,
            price = 3,
            image = R.drawable.ic_restaurant_klopa,
            city = "Sarajevo",
            cost = "20$",
            details = "Immerse yourself in the rich history of Sarajevo as you explore its iconic landmarks and historical sites. This guided walking tour takes you through the enchanting old town, where you'll discover the ancient Bascarsija Square, visit the grand Gazi Husrev-beg Mosque, explore the intriguing Sarajevo City Hall, and learn about the city's fascinating past at the Sarajevo Museum. Experience the blend of Ottoman, Austro-Hungarian, and modern influences that have shaped this captivating city."
        ),
        ToursModel(
            id = 20,
            title = "Tastes of Sarajevo Food Tour",
            type = TourType.POPULAR,
            rating = 4.6,
            price = 2,
            image = R.drawable.ic_restaurant_klopa,
            city = "Sarajevo",
            cost = "34$",
            details = "Embark on a culinary adventure through Sarajevo's vibrant food scene. This gastronomic tour introduces you to the city's diverse flavors and traditionaldishes. Indulge in delicious cevapi, a local specialty of grilled meat served with warm flatbread, or savor the hearty flavors of Sarajevski Stew. Explore the bustling markets and try authentic Bosnian sweets like baklava. Along the way, your knowledgeable guide will share insights into the cultural significance of the food and its connection to Sarajevo's history."
        ),
        ToursModel(
            id = 21,
            title = "Klopa",
            type = TourType.POPULAR,
            rating = 4.6,
            price = 2,
            image = R.drawable.ic_restaurant_klopa,
            city = "Sarajevo",
            cost = "34$",
            details = "Klopa is a cozy and family-friendly restaurant that celebrates the rich culinary heritage of Bosnia and Herzegovina. Located in a traditional house, it offers a warm and inviting atmosphere with rustic decor and friendly service. The menu features a range of traditional Bosnian dishes, including hearty soups, comforting stews, and savory pies. Klopa takes pride in using locally sourced ingredients, ensuring the freshness and authenticity of its dishes. The restaurant's warm ambiance and delicious food make it a favorite among locals and visitors alike."
        ),
        ToursModel(
            id = 22,
            title = "Historical Heritage Walk",
            type = TourType.RECOMMENDED,
            rating = 4.6,
            price = 2,
            image = R.drawable.ic_restaurant_klopa,
            city = "Sarajevo",
            cost = "34$",
            details = "Klopa is a cozy and family-friendly restaurant that celebrates the rich culinary heritage of Bosnia and Herzegovina. Located in a traditional house, it offers a warm and inviting atmosphere with rustic decor and friendly service. The menu features a range of traditional Bosnian dishes, including hearty soups, comforting stews, and savory pies. Klopa takes pride in using locally sourced ingredients, ensuring the freshness and authenticity of its dishes. The restaurant's warm ambiance and delicious food make it a favorite among locals and visitors alike."
        )
    )
}