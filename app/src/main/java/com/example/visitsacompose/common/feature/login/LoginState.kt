package com.example.visitsacompose.common.feature.login

data class LoginState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val token: String
) {
    companion object {
        val initial = LoginState(
            isLoading = false,
            error = null,
            token = ""
        )
    }
}