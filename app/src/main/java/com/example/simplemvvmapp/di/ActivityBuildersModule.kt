package com.example.simplemvvmapp.di

import com.example.simplemvvmapp.di.scope.ActivityScope
import com.example.simplemvvmapp.ui.MainActivity
import com.example.simplemvvmapp.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

