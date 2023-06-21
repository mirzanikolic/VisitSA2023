package com.example.visitsacompose.common.feature.register

sealed class RegisterEvent {
    object ScreenStarted : RegisterEvent()
    data class RegisterUser(val username: String, val email: String, val password: String) : RegisterEvent()
    data class ResponseReceived(val status: String?) : RegisterEvent()
    data class Error(val throwable: Throwable) : RegisterEvent()
}