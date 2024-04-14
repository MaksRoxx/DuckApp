package com.example.duckapp.di

import com.example.duckapp.data.DuckRepository
import com.example.duckapp.data.DuckRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepModule {
    @Binds
    @Singleton
    abstract fun bindRepDuck(repositoryImpl: DuckRepositoryImpl): DuckRepository
}