package com.example.visitsacompose.common.network.repository

import com.example.visitsacompose.common.model.payload.LoginPayload
import com.example.visitsacompose.common.model.response.LoginResponse
import com.example.visitsacompose.common.network.common.DataRepository
import javax.inject.Inject

class LoginAuthRepository @Inject constructor() : DataRepository<LoginPayload, LoginResponse>() {
    override suspend fun fetchData(payload: LoginPayload): LoginResponse {
        return retrofitClient.getAuthAPI().loginUser(payload)
    }
}