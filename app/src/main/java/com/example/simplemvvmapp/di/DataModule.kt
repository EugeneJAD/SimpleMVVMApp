package com.example.simplemvvmapp.di

import com.example.simplemvvmapp.data.DataRepository
import com.example.simplemvvmapp.data.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRepository(repository: DataRepository): Repository = repository
}