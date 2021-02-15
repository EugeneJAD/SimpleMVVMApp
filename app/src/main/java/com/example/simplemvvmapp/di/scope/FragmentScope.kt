package com.example.simplemvvmapp.di.scope

import javax.inject.Scope

/**
 * Specifies the lifespan of a dependency be the same as that of an Activity
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope