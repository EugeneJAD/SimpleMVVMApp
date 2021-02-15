package com.example.simplemvvmapp.di

import android.app.Application
import com.example.simplemvvmapp.SimpleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuildersModule::class,
    NetworkModule::class
])
interface AppComponent: AndroidInjector<SimpleApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}