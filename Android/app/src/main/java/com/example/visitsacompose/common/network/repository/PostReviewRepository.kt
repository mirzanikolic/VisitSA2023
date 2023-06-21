package com.example.visitsacompose.common.network.repository

import com.example.visitsacompose.common.model.payload.ReviewPayload
import com.example.visitsacompose.common.network.common.DataRepository
import javax.inject.Inject

class PostReviewRepository @Inject constructor() : DataRepository<ReviewPayload, String>() {
    override suspend fun fetchData(payload: ReviewPayload): String {
        return retrofitClient.getAttractionsAPI().postReview(payload)
    }
}