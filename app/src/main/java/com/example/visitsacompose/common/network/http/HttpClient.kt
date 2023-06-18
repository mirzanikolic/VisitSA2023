package com.example.visitsacompose.common.network.http

import okhttp3.OkHttpClient

interface HttpClient {
    fun getClient(): OkHttpClient
}