package com.example.pukapp.api

import com.example.pukapp.model.Recording
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("puks?")
    fun getRecordings(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ) : Call<MutableList<Recording>>
}