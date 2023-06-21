package com.example.visitsacompose.common.feature.login

sealed class LoginEvent {
    object ScreenStarted : LoginEvent()
    data class LoginUser(val email: String, val password: String) : LoginEvent()
    data class ResponseReceived(val token: String?) : LoginEvent()
    data class Error(val throwable: Throwable?) : LoginEvent()
}