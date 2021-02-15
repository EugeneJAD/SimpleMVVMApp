package com.example.simplemvvmapp.ui

import com.example.simplemvvmapp.ui.home.HomeModule
import dagger.Module

@Module(includes = [HomeModule::class])
abstract class MainActivityModule