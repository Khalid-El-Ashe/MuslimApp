package com.dev.imuslim.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.imuslim.models.Athckar
import com.dev.imuslim.models.ResultState
import com.dev.imuslim.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AthckarViewModel : ViewModel() {
    private val _athkarState = MutableStateFlow<ResultState<List<Athckar>>>(ResultState.Loading)
    val athkarState: StateFlow<ResultState<List<Athckar>>> = _athkarState

    init {
        getAthkar()
        println("you are in the init method of athkar view model")
    }

    fun getAthkar() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getAthkar()
                _athkarState.value = ResultState.Success(response)
            } catch (e: Exception) {
                _athkarState.value = ResultState.Failure(e)
            }
        }
    }
}