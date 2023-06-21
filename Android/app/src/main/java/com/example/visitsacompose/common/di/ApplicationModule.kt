package com.example.visitsacompose.common.di

import android.content.Context
import android.content.SharedPreferences
import com.example.visitsacompose.common.network.http.HttpClient
import com.example.visitsacompose.common.network.http.HttpClientImpl
import com.example.visitsacompose.common.network.interceptor.Interceptor
import com.example.visitsacompose.common.network.interceptor.InterceptorImpl
import com.example.visitsacompose.common.network.retrofit.RetrofitClient
import com.example.visitsacompose.common.network.retrofit.RetrofitClientImpl
import com.example.visitsacompose.common.network.serializer.Serializer
import com.example.visitsacompose.common.network.serializer.SerializerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
open class ApplicationModule {

    @Singleton
    @Provides
    fun httpClient(httpClient: HttpClientImpl): HttpClient = httpClient

    @Singleton
    @Provides
    fun interceptor(interceptor: InterceptorImpl): Interceptor = interceptor

    @Singleton
    @Provides
    fun retrofit(retrofit: RetrofitClientImpl): RetrofitClient = retrofit

    @Singleton
    @Provides
    fun serializer(serializer: SerializerImpl): Serializer = serializer

    @Singleton
    @Provides
    fun sharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(context.packageName, 0)
}