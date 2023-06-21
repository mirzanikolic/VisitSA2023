package com.example.visitsacompose.common.feature.register

import android.content.SharedPreferences
import androidx.lifecycle.viewModelScope
import com.example.visitsacompose.common.BaseViewModel
import com.example.visitsacompose.common.model.payload.RegisterPayload
import com.example.visitsacompose.common.network.repository.RegisterAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerAuthRepository: RegisterAuthRepository,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel<RegisterState, RegisterEvent>() {

    init {
        state.handleEvent(RegisterEvent.ScreenStarted)
    }

    override fun reduceState(
        currentState: RegisterState,
        event: RegisterEvent
    ): RegisterState = when (event) {
        is RegisterEvent.ScreenStarted -> {
            isLaunched = true
            currentState.copy(isLoading = true)
        }

        is RegisterEvent.ResponseReceived -> {
            val response = event.status
            currentState.copy(
                isLoading = false,
                status = response ?: ""
            )
        }

        is RegisterEvent.RegisterUser -> {
            registerUser(event.username, event.email, event.password)
            currentState.copy(isLoading = false)
        }

        is RegisterEvent.Error -> currentState.copy(isLoading = false, error = event.throwable)
    }

    override fun getInitialState(): RegisterState = RegisterState.initial

    private fun registerUser(username: String, email: String, password: String) =
        viewModelScope.launch {
            registerAuthRepository.fetch(RegisterPayload(username, email, password)).mapToState(
                {
                    RegisterEvent.ResponseReceived(
                        status = it.status
                    )
                },
                { RegisterEvent.Error(it) }
            )
        }
}