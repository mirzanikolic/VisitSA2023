package com.example.visitsacompose.common.network.api

import com.example.visitsacompose.common.model.response.AttractionsResponse
import retrofit2.http.GET

interface AttractionsAPI {

    @GET("/items")
    suspend fun getAttractions() : AttractionsResponse
}