package com.dev.imuslim.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.imuslim.models.ResultState
import com.dev.imuslim.models.Stories
import com.dev.imuslim.models.Story
import com.dev.imuslim.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {
    private val _storiesState = MutableStateFlow<ResultState<List<Stories>>>(ResultState.Loading)
    val storiesState: StateFlow<ResultState<List<Stories>>> = _storiesState

    init {
        getQuranStories()
    }

    fun getQuranStories() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getQuranicStories()
//                println("response the stories $response")
                _storiesState.value = ResultState.Success(response)
            } catch (e: Exception) {
                _storiesState.value = ResultState.Failure(e)
            }
        }
//        viewModelScope.launch {
//            try {
//                val resonse = RetrofitInstance.api.getQuranicStories()
//                _storiesState.value = ResultState.Success(resonse)
//            } catch (e: Exception) {
//                _storiesState.value = ResultState.Failure(e)
//            }
//        }
    }
}