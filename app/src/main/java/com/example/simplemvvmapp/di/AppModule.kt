package com.example.simplemvvmapp.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideResources(application: Application): Resources = application.resources

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context = application.applicationContext
}
