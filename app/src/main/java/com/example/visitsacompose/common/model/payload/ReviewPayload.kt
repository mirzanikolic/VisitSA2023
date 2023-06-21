package com.example.visitsacompose.common.model.payload

data class ReviewPayload(
    val userId: Int,
    val itemId: Int,
    val comment: String,
    val grade: Int,
)