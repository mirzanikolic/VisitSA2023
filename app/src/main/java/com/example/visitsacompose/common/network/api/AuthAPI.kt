package com.example.visitsacompose.common.network.api

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("/login")
    fun loginUser(@Body payload: ) :
}