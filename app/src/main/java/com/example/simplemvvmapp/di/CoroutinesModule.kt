package com.example.simplemvvmapp.di

import com.example.simplemvvmapp.utils.CoroutinesDispatcherProvider
import com.example.simplemvvmapp.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CoroutinesModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(provider: CoroutinesDispatcherProvider): DispatcherProvider = provider
}