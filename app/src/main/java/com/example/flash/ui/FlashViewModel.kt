package com.example.flash.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flash.data.InternetItem
import com.example.flash.network.FlashApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

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

    val _isVisible = MutableStateFlow<Boolean>(true)
    val isVisible = _isVisible
    var itemUiState: ItemUiState by mutableStateOf(ItemUiState.Loading("Loading..."))
        private set
    lateinit var internetJob: Job
    lateinit var screenJob: Job
    sealed interface ItemUiState{
        data class Success(val items:  List<InternetItem>): ItemUiState
        data class Loading(val message: String): ItemUiState
        data class Error(val message: String): ItemUiState
    }

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
    fun toggleVisibility(){
        _isVisible.value = false
    }

    fun getFlashItems(){
      internetJob = viewModelScope.launch {
        try{
            val listResult = FlashApi.retrofitService.getItems()
            itemUiState = ItemUiState.Success(listResult)
        }catch (exeption : Exception )
        {
            itemUiState = ItemUiState.Error("Internet connectivity unavailable." +
                    "Please turn on the internet and try again")
            toggleVisibility()
            screenJob.cancel()
        }
        }
    }
    init {
       screenJob = viewModelScope.launch(Dispatchers.Default) {
            delay(3000.milliseconds)
            toggleVisibility()

        }
        getFlashItems()
    }
}