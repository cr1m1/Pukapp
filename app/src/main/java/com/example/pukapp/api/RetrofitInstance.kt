package com.example.pukapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val log = HttpLoggingInterceptor()
            log.setLevel(HttpLoggingInterceptor.Level.BODY)

            val cl = OkHttpClient.Builder()
                .addInterceptor(log)
                .build()

            Retrofit.Builder()
                .baseUrl("https://puk-bot.herokuapp.com/api/")
                .client(cl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
            retrofit.create(ServiceApi::class.java)
        }
    }
}