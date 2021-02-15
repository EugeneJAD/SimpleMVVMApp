package com.example.simplemvvmapp.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provide coroutines context.
 */
@Singleton
class CoroutinesDispatcherProvider @Inject constructor() : DispatcherProvider {
  override val main: CoroutineDispatcher = Dispatchers.Main
  override val computation: CoroutineDispatcher = Dispatchers.Default
  override val io: CoroutineDispatcher = Dispatchers.IO
}

interface DispatcherProvider {
  val main: CoroutineDispatcher
  val computation: CoroutineDispatcher
  val io: CoroutineDispatcher
}

