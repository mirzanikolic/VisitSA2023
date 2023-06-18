package com.example.visitsacompose.common.network.common

import okhttp3.Interceptor

abstract class BaseInterceptor {
    fun requestInterceptor(): Interceptor {
        return Interceptor { chain ->
            // Intercepting and adjusting request
            val builder = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
            chain.proceed(builder.build())
        }
    }

    fun responseInterceptor(): Interceptor {
        return Interceptor { chain ->
            val response = chain.proceed(chain.request())
            response
        }
    }
}