package com.example.petapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputDataClass())

    fun onEventChange(events: UserDataUiEvents) {

        when (events) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = events.name)
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(animalSelected = events.animalValue)
            }
        }
    }

    fun isValidState() : Boolean{
        return !uiState.value.animalSelected.isNullOrEmpty() && !uiState.value.nameEntered.isNullOrEmpty()
    }
}

data class UserInputDataClass(
    var nameEntered: String = "",
    var animalSelected: String = ""
)

sealed class UserDataUiEvents {
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class AnimalSelected(val animalValue: String) : UserDataUiEvents()
}