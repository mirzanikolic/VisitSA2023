package com.example.visitsacompose.common.network.retrofit

import com.example.visitsacompose.common.network.api.AttractionsAPI
import com.example.visitsacompose.common.network.api.AuthAPI

interface RetrofitClient {
    fun getAttractionsAPI(): AttractionsAPI
    fun getAuthAPI(): AuthAPI
}