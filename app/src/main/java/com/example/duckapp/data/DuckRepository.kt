package com.example.duckapp.data

import kotlinx.coroutines.flow.Flow

interface DuckRepository {
    suspend fun getRandomImage(type: String): Flow<Result<Duck>>
    suspend fun getQuack(): Flow<Result<Duck>>
}