package com.example.visitsacompose.common.network.serializer

import com.squareup.moshi.Moshi

interface Serializer {
    fun getMoshi(): Moshi
}