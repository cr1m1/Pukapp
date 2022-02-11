package com.example.pukapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val API = "https://puk-bot.herokuapp.com/api/"

    private val retrofitClient : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val serviceApi : ServiceApi by lazy {
        retrofitClient
            .build()
            .create(ServiceApi::class.java)
    }
}