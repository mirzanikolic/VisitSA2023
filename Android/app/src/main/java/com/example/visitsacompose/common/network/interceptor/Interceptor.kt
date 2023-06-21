package com.example.visitsacompose.common.network.interceptor

interface Interceptor {
    fun getApplicationInterceptors(): List<okhttp3.Interceptor>
    fun headerInterceptor(): okhttp3.Interceptor
    fun cacheInterceptor(): okhttp3.Interceptor
    fun loggingInterceptor(): okhttp3.Interceptor
}