package com.example.pukapp.repo

import androidx.lifecycle.MutableLiveData
import com.example.pukapp.api.RetrofitClient
import com.example.pukapp.api.ServiceApi
import com.example.pukapp.model.Recording
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivityRepository constructor(private val serviceApi: ServiceApi){
    fun getAllRecordings() = serviceApi.getRecordings(0, 100)
}