package com.example.duckapp.data

import com.example.duckapp.data.Duck
import com.example.duckapp.data.RandomImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckApi {
    @GET("random")
    suspend fun getRandomImage(@Query("type") type: String): Duck

    @GET("quack")
    suspend fun getQuack(): Duck

    @GET("randomimg")
    suspend fun getListDucks(): RandomImages

    companion object{
        const val BASE_URL = "https://random-d.uk/api/"
    }
}