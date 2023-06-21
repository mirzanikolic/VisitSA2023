package com.example.visitsacompose.common.feature.login

import android.content.SharedPreferences
import androidx.lifecycle.viewModelScope
import com.example.visitsacompose.common.BaseViewModel
import com.example.visitsacompose.common.model.payload.LoginPayload
import com.example.visitsacompose.common.network.repository.LoginAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginAuthRepository: LoginAuthRepository,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel<LoginState, LoginEvent>() {

    init {
        state.handleEvent(LoginEvent.ScreenStarted)
    }

    override fun reduceState(
        currentState: LoginState,
        event: LoginEvent
    ): LoginState = when (event) {
        is LoginEvent.ScreenStarted -> {
            isLaunched = true
            currentState.copy(isLoading = true)
        }

        is LoginEvent.ResponseReceived -> {
            val token = event.token
            currentState.copy(
                isLoading = false,
                token = token
            )
        }
        is LoginEvent.LoginUser -> {
            loginUser(event.email, event.password)
            currentState.copy(isLoading = false)
        }
        is LoginEvent.Error -> currentState.copy(isLoading = false, error = event.throwable)
    }

    override fun getInitialState(): LoginState = LoginState.initial

    private fun loginUser(email: String, password: String) = viewModelScope.launch {
        loginAuthRepository.fetch(LoginPayload(email, password)).mapToState(
            {
                sharedPreferences.edit().putString("token", it.token).apply()
                LoginEvent.ResponseReceived(
                    token = it.token
                )
            },
            { LoginEvent.Error(it) }
        )
    }
}