package com.example.flash.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlashViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(FlashUiState())
    //uiState Object : an Obj created from  inbuilt class MutableStateFlow class in jetpack Compose

    //MutableStateFlow(FlashUIState()) : It is like a secure box that serves as a Single
    // source of truth for data for an Android App
    //Holds information about how our app looks and works
    //it is used for Observes the UI state of an Android App
    //Allows the UI elements to update automatically when data in the FlashUiState() changes
    //it is secure object because it doesnot allow other parts of the code to change its information

    val uiState: StateFlow<FlashUiState> = _uiState.asStateFlow()

    fun updateClickText(updatedText: String){
         _uiState.update {
             it.copy(clickStatus = updatedText)
         }
    }

    fun updateSelectedCategory(updatedCategory: Int){
        _uiState.update {
            it.copy(
                selectedCategory = updatedCategory
            )
        }
    }
}