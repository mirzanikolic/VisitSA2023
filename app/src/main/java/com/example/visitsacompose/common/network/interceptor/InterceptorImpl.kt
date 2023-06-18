package com.example.visitsacompose.common.network.interceptor

import com.example.visitsacompose.common.network.common.BaseInterceptor
import okhttp3.CacheControl
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class InterceptorImpl @Inject constructor() : BaseInterceptor(), Interceptor {

    override fun loggingInterceptor(): okhttp3.Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
//            if (BuildConfig.DEBUG) {
//                Log.d("API", message)
//            }
        }
//        loggingInterceptor.level =
//            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
//            else HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }

    override fun headerInterceptor(): okhttp3.Interceptor {
        return okhttp3.Interceptor {
            val requestWithHeaders = it.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build()
            it.proceed(requestWithHeaders)
        }
    }

    override fun cacheInterceptor(): okhttp3.Interceptor {
        return okhttp3.Interceptor {
            val cacheControl: CacheControl = CacheControl.Builder()
                .onlyIfCached()
                .maxAge(15, TimeUnit.MINUTES) // 15 minutes cache
                .build()

            val response = it.proceed(it.request())
            return@Interceptor response.newBuilder()
                .removeHeader("Cache-Control")
                .header("Cache-Control", cacheControl.toString())
                .build()
        }
    }

    override fun getApplicationInterceptors() =
        listOf(
            requestInterceptor(),
            responseInterceptor(),
            cacheInterceptor()
        )
}