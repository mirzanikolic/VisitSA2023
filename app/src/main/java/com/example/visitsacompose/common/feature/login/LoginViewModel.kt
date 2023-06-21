package com.example.visitsacompose.common.feature.login

import android.util.Log
import androidx.compose.runtime.remember
import androidx.lifecycle.viewModelScope
import com.example.visitsacompose.common.BaseViewModel
import com.example.visitsacompose.common.feature.home.HomeEvent
import com.example.visitsacompose.common.feature.home.HomeState
import com.example.visitsacompose.common.network.repository.GetAttractionsRepository
import com.example.visitsacompose.common.network.repository.LoginAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginAuthRepository: LoginAuthRepository
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
            loginUser()
        }
        is LoginEvent.Error -> currentState.copy(isLoading = false, error = event.throwable)
    }

    override fun getInitialState(): LoginState = LoginState.initial

    private fun loginUser() = viewModelScope.launch {
        loginAuthRepository.fetch().mapToState(
            {
                HomeEvent.AttractionsLoaded(
                    attractions = it.items
                )
            },
            { HomeEvent.Error(it) }
        )
    }
}