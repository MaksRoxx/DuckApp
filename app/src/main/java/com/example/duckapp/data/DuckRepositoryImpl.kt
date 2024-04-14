package com.example.duckapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DuckRepositoryImpl @Inject constructor(
    private val api: DuckApi
) : DuckRepository {
    override suspend fun getRandomImage(type: String): Flow<Result<Duck>> {
        return flow {
            val duck = try {
                api.getRandomImage(type)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading duck"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading duck"))
                return@flow
            }
            emit(Result.Success(duck))
        }
    }

    override suspend fun getQuack(): Flow<Result<Duck>> {
        return flow {
            val duck = try {
                api.getQuack()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading duck"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading duck"))
                return@flow
            }
            emit(Result.Success(duck))
        }
    }
}