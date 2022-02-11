package com.example.pukapp.api

import com.example.pukapp.model.Response as MyResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServiceApi {

    @GET("puks?page=0&limit=100")
    fun getRecordings() : Response<MyResponse>

    companion object Factory {
        fun create(): ServiceApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://puk-bot.herokuapp.com/api/")
                .build()

            return retrofit.create(ServiceApi::class.java)
        }
    }
}