package com.example.duckapp.retrofit

import com.example.duckapp.retrofit.DuckApi.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInst {
    val api: DuckApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DuckApi::class.java)
    }
}