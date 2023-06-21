package com.example.visitsacompose.common.network.common

import com.example.visitsacompose.common.model.base.Response
import com.example.visitsacompose.common.network.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

abstract class DataRepository<P, R : Any> {
    @Inject
    lateinit var retrofitClient: RetrofitClient

    protected abstract suspend fun fetchData(payload: P): R

    suspend fun fetch(payload: P): Response<R> {
        return withContext(Dispatchers.IO) {
            try {
                Response.Success(fetchData(payload))
            } catch (throwable: Throwable) {
                Response.Error(throwable)
            }
        }
    }
}