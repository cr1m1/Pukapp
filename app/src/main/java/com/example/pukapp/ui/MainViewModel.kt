package com.example.pukapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pukapp.model.Recording
import com.example.pukapp.repo.MainActivityRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (
    private val repository: MainActivityRepository
) : ViewModel() {
    val list: MutableLiveData<MutableList<Recording>> = MutableLiveData()
    var errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getAllRecordings() {
        val response = repository.getAllRecordings()

        response.enqueue(object : Callback<MutableList<Recording>>{
            override fun onResponse(
                call: Call<MutableList<Recording>>,
                response: Response<MutableList<Recording>>
            ) {
                list.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Recording>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}