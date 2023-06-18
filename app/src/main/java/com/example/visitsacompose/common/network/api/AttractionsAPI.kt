package com.example.visitsacompose.common.network.api

import com.example.visitsacompose.common.model.HomeItemModel
import retrofit2.http.GET

interface AttractionsAPI {

    @GET("/items")
    suspend fun getAttractions() : HomeItemModel
}