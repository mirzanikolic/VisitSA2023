package com.example.visitsacompose.common.feature.itemdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visitsacompose.common.BaseViewModel
import com.example.visitsacompose.common.feature.home.HomeEvent
import com.example.visitsacompose.common.feature.home.HomeState
import com.example.visitsacompose.common.network.repository.GetSingleAttractionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSingleAttractionRepository: GetSingleAttractionRepository
) : BaseViewModel<ItemDetailsState, ItemDetailsEvent>() {
    val itemId: Long = checkNotNull(savedStateHandle["id"])

    init {
        state.handleEvent(ItemDetailsEvent.ScreenStarted)
    }

    override fun reduceState(
        currentState: ItemDetailsState,
        event: ItemDetailsEvent
    ): ItemDetailsState = when (event) {
        is ItemDetailsEvent.ScreenStarted -> {
            isLaunched = true
            fetchSingleAttraction()
            currentState.copy(isLoading = true)
        }

        is ItemDetailsEvent.AttractionLoaded -> {
            val attraction = event.attraction
            currentState.copy(
                isLoading = false,
                attraction = attraction
            )
        }

        is ItemDetailsEvent.Error -> currentState.copy(isLoading = false, error = event.throwable)
    }

    override fun getInitialState(): ItemDetailsState = ItemDetailsState.initial

    private fun fetchSingleAttraction() = viewModelScope.launch {
        getSingleAttractionRepository.fetch(itemId.toString()).mapToState(
            {
                ItemDetailsEvent.AttractionLoaded(
                    attraction = it
                )
            },
            { ItemDetailsEvent.Error(it) }
        )
    }

}