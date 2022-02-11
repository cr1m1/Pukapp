package com.example.pukapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pukapp.model.Response as MyResponse
import com.example.pukapp.repo.MainActivityRepository

class MainViewModel (
    private val repository: MainActivityRepository
) : ViewModel() {
    val list: MutableLiveData<MyResponse> = MutableLiveData()

    fun getAllRecordings() {
        val response = repository.getAllRecordings()
        if (response.isSuccessful) list.postValue(response.body())
    }
}