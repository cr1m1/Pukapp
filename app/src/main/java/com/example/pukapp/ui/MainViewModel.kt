package com.example.pukapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pukapp.model.Recording
import com.example.pukapp.model.Result
import com.example.pukapp.repo.MainActivityRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (
    private val repository: MainActivityRepository
) : ViewModel() {
    var recList: MutableLiveData<Result> = MutableLiveData()

    init {
        getAllRecordings()
    }

   private fun getAllRecordings() {
       viewModelScope.launch {
           val response = repository.getRecordings()

           if (response.isSuccessful) {
               recList.postValue(response.body())
           }
       }
    }
}