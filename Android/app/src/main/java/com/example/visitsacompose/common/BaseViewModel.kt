package com.example.visitsacompose.common

import androidx.lifecycle.ViewModel
import com.example.visitsacompose.common.model.base.Response

abstract class BaseViewModel<STATE, EVENT> : ViewModel() {
    open var isLaunched = false

    open val state = StateReducerFlow(
        initialState = getInitialState(),
        reduceState = ::reduceState,
    )

    abstract fun reduceState(
        currentState: STATE,
        event: EVENT
    ): STATE

    abstract fun getInitialState(): STATE

    fun <T> Response<T>.mapToState(
        onSuccess: (T) -> EVENT,
        onError: (Throwable) -> EVENT
    ) {
        when (this) {
            is Response.Success -> state.handleEvent(onSuccess.invoke(this.data))
            is Response.Error -> state.handleEvent(onError.invoke(this.error))
        }
    }
}