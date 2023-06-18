package com.example.visitsacompose.common.network.retrofit

import com.example.visitsacompose.common.network.api.AttractionsAPI
import com.example.visitsacompose.common.network.http.HttpClient
import com.example.visitsacompose.common.network.serializer.Serializer
import com.example.visitsacompose.common.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RetrofitClientImpl @Inject constructor(
    private val httpClient: HttpClient,
    private val serializer: Serializer
) : RetrofitClient {

    override fun getAttractionsAPI(): AttractionsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.API.API_URL)
            .addConverterFactory(MoshiConverterFactory.create(serializer.getMoshi()))
            .client(httpClient.getClient())
            .build()
            .create(AttractionsAPI::class.java)
    }
}