package com.example.pukapp.api

import com.example.pukapp.model.Result
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("puks?page=0&limit=100")
   suspend fun getRecordings() : Response<Result>
}