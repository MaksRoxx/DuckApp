package com.example.duckapp.randomduckpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duckapp.model.Duck
import com.example.duckapp.retrofit.RetrofitInst
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RandomDuckPageViewModel : ViewModel() {
    private val _duckLiveData = MutableLiveData<Duck?>()
    val duckLiveData: LiveData<Duck?> = _duckLiveData

    init {
        getQuack()
    }

    fun getQuack(){
        viewModelScope.launch {
            try {
                val response = RetrofitInst.api.getQuack()
                if (response.isSuccessful) {
                    _duckLiveData.value = response.body()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }
}