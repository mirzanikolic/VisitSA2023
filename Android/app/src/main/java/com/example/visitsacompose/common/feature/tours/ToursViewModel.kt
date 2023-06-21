package com.example.visitsacompose.common.feature.tours

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.visitsacompose.common.BaseViewModel
import com.example.visitsacompose.common.feature.home.HomeEvent
import com.example.visitsacompose.common.feature.home.HomeState
import com.example.visitsacompose.common.feature.itemdetails.ItemDetailsEvent
import com.example.visitsacompose.common.feature.itemdetails.ItemDetailsState
import com.example.visitsacompose.common.network.repository.GetAttractionsRepository
import com.example.visitsacompose.common.network.repository.GetSingleAttractionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToursViewModel @Inject constructor(
    private val getAttractionsRepository: GetAttractionsRepository
) : BaseViewModel<ToursState, ToursEvent>() {

    init {
        state.handleEvent(ToursEvent.ScreenStarted)
    }


    override fun reduceState(
        currentState: ToursState,
        event: ToursEvent
    ): ToursState = when (event) {
        is ToursEvent.ScreenStarted -> {
            isLaunched = true
            fetchAttractions()
            currentState.copy(isLoading = true)
        }

        is ToursEvent.AttractionsLoaded -> {
            val attractions = event.attractions
            currentState.copy(
                isLoading = false,
                attractions = attractions
            )
        }

        is ToursEvent.Error -> currentState.copy(isLoading = false, error = event.throwable)
    }

    override fun getInitialState(): ToursState = ToursState.initial

    private fun fetchAttractions() = viewModelScope.launch {
        getAttractionsRepository.fetch(Unit).mapToState(
            {
                ToursEvent.AttractionsLoaded(
                    attractions = it.items
                )
            },
            { ToursEvent.Error(it) }
        )
    }
}