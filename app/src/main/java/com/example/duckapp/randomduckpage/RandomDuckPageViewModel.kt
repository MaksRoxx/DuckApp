package com.example.duckapp.randomduckpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duckapp.data.Duck
import com.example.duckapp.data.DuckRepository
import com.example.duckapp.data.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomDuckPageViewModel @Inject constructor(
    private val duckRepository: DuckRepository
) : ViewModel() {
    private val _duck = MutableStateFlow(Duck("", ""))
    val duck = _duck.asStateFlow()
    val isLoading = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            getRandomImage()
        }
    }

    suspend fun getRandomImage() {
        isLoading.emit(true)
        duckRepository.getRandomImage("gif").collectLatest { result ->
            when (result) {
                is Result.Error -> {
                    println("Result Error")
                }

                is Result.Success -> {
                    println("Result Success")
                    result.data?.let { duck ->
                        _duck.update { duck }
                    }
                }
            }
        }
        isLoading.emit(false)
    }

    suspend fun getQuack() {
        isLoading.emit(true)
        duckRepository.getQuack().collectLatest { result ->
            when (result) {
                is Result.Error -> {
                    println("Result Error")
                }

                is Result.Success -> {
                    println("Result Success")
                    result.data?.let { duck ->
                        _duck.update { duck }
                    }
                }
            }
        }
        isLoading.emit(false)
    }
}