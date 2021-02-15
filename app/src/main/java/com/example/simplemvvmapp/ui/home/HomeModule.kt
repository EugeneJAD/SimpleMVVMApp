package com.example.simplemvvmapp.ui.home

import com.example.simplemvvmapp.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

}