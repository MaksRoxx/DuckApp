package com.example.duckapp.data

data class RandomImages(
    val gif_count: Int,
    val gifs: List<String>,
    val http: List<String>,
    val image_count: Int,
    val images: List<String>
)
