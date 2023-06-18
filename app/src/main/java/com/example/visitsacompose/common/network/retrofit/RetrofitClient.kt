package com.example.visitsacompose.common.network.retrofit

import com.example.visitsacompose.common.network.api.AttractionsAPI

interface RetrofitClient {
    fun getAttractionsAPI(): AttractionsAPI
}