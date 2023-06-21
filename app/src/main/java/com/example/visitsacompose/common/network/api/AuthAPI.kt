package com.example.visitsacompose.common.network.api

import com.example.visitsacompose.common.model.payload.LoginPayload
import com.example.visitsacompose.common.model.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("/login")
    fun loginUser(@Body payload: LoginPayload) : LoginResponse
}