package com.example.visitsacompose.common.feature.register

data class RegisterState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val status: String? = null
) {
    companion object {
        val initial = RegisterState(
            isLoading = false,
            error = null,
            status = null
        )
    }
}