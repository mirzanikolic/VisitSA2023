package com.example.visitsacompose.common.network.repository

import com.example.visitsacompose.common.model.response.AttractionsResponse
import com.example.visitsacompose.common.network.common.DataRepository
import javax.inject.Inject

class GetAttractionsRepository @Inject constructor() : DataRepository<Unit, AttractionsResponse>() {
    override suspend fun fetchData(payload: Unit): AttractionsResponse {
        return retrofitClient
            .getAttractionsAPI()
            .getAttractions()
    }
}