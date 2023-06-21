package com.example.visitsacompose.common.feature.home

import androidx.lifecycle.viewModelScope
import com.example.visitsacompose.common.BaseViewModel
import com.example.visitsacompose.common.network.repository.GetAttractionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAttractionsRepository: GetAttractionsRepository
) : BaseViewModel<HomeState, HomeEvent>() {

    init {
        state.handleEvent(HomeEvent.ScreenStarted)
    }


    override fun reduceState(
        currentState: HomeState,
        event: HomeEvent
    ): HomeState = when (event) {
        is HomeEvent.ScreenStarted -> {
            isLaunched = true
            fetchAttractions()
            currentState.copy(isLoading = true)
        }

        is HomeEvent.AttractionsLoaded -> {
            val attractions = event.attractions
            currentState.copy(
                isLoading = false,
                attractions = attractions
            )
        }

        is HomeEvent.Error -> currentState.copy(isLoading = false, error = event.throwable)
    }

    override fun getInitialState(): HomeState = HomeState.initial

    private fun fetchAttractions() = viewModelScope.launch {
        getAttractionsRepository.fetch(Unit).mapToState(
            {
                HomeEvent.AttractionsLoaded(
                    attractions = it.items
                )
            },
            { HomeEvent.Error(it) }
        )
    }
}