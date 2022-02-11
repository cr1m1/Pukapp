package com.example.pukapp.repo

import com.example.pukapp.api.ServiceApi

class MainActivityRepository {
    fun getAllRecordings() = ServiceApi.create()
}