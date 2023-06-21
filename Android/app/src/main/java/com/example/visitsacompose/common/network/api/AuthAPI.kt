package com.example.visitsacompose.common.network.api

import com.example.visitsacompose.common.model.payload.LoginPayload
import com.example.visitsacompose.common.model.payload.RegisterPayload
import com.example.visitsacompose.common.model.response.LoginResponse
import com.example.visitsacompose.common.model.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("/login")
    suspend fun loginUser(@Body payload: LoginPayload) : LoginResponse

    @POST("/register")
    suspend fun registerUser(@Body payload: RegisterPayload) : RegisterResponse
}