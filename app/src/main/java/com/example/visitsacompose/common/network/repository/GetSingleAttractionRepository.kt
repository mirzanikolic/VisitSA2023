package com.example.visitsacompose.common.network.repository

import com.example.visitsacompose.common.model.HomeItemModel
import com.example.visitsacompose.common.network.common.DataRepository
import javax.inject.Inject

class GetSingleAttractionRepository @Inject constructor() : DataRepository<String, HomeItemModel>() {
    override suspend fun fetchData(payload: String): HomeItemModel {
        return retrofitClient.getAttractionsAPI().getAttractionWithReview(payload)
    }
}