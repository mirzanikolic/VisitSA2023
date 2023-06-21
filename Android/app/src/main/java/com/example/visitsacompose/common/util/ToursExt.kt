package com.example.visitsacompose.common.util

fun Int.isTourAllowed(): Boolean {
    return when (this) {
        1 -> true
        2 -> false
        else -> true
    }
}