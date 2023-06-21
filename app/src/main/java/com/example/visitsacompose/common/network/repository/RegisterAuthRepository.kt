package com.example.visitsacompose.common.network.repository

import com.example.visitsacompose.common.model.payload.RegisterPayload
import com.example.visitsacompose.common.model.response.RegisterResponse
import com.example.visitsacompose.common.network.common.DataRepository
import javax.inject.Inject

class RegisterAuthRepository @Inject constructor() :
    DataRepository<RegisterPayload, RegisterResponse>() {
    override suspend fun fetchData(payload: RegisterPayload): RegisterResponse {
        return retrofitClient.getAuthAPI().registerUser(payload)
    }
}