package com.example.visitsacompose.common.network.http

import com.example.visitsacompose.common.network.interceptor.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HttpClientImpl @Inject constructor(
    private val interceptor: Interceptor
) : HttpClient {

    override fun getClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

        interceptor.getApplicationInterceptors()
            .forEach {
                okHttpClientBuilder.addInterceptor(it)
            }
        return okHttpClientBuilder.build()
    }
}
