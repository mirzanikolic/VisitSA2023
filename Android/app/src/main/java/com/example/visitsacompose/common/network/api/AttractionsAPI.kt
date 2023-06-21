package com.example.visitsacompose.common.network.api

import com.example.visitsacompose.common.model.HomeItemModel
import com.example.visitsacompose.common.model.payload.ReviewPayload
import com.example.visitsacompose.common.model.response.AttractionsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AttractionsAPI {

    @GET("/items")
    suspend fun getAttractions() : AttractionsResponse

    @GET("/items/{id}/reviews")
    suspend fun getAttractionWithReview(@Path("id") id: String) : HomeItemModel

    @POST("/reviews")
    suspend fun postReview(@Body reviewPayload: ReviewPayload) : String
}