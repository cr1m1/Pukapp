package com.example.pukapp.repo

import com.example.pukapp.api.RetrofitInstance
import com.example.pukapp.api.ServiceApi

class MainActivityRepository {
  suspend fun getRecordings() = RetrofitInstance.api.getRecordings()
}