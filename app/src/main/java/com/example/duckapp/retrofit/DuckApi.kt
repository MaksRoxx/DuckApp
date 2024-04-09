package com.example.duckapp.retrofit

import com.example.duckapp.model.Duck
import com.example.duckapp.model.RandomImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckApi {
    @GET("random")
    suspend fun getRandomImage(@Query("type") type: String): Response<Duck>

    @GET("quack")
    suspend fun getQuack(): Response<Duck>

    @GET("randomimg")
    suspend fun getListDucks(): Response<RandomImages>

    companion object{
        const val BASE_URL = "https://random-d.uk/api/"
    }
}