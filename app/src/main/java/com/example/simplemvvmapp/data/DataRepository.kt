package com.example.simplemvvmapp.data

import androidx.annotation.WorkerThread
import com.example.simplemvvmapp.data.remote.RemoteDataSource
import com.example.simplemvvmapp.domain.Repository
import com.example.simplemvvmapp.domain.model.Task
import com.example.simplemvvmapp.domain.model.toTask
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.Throws

@Singleton
class DataRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
  Repository {

  @WorkerThread
  @Throws
  override suspend fun loadTasks(): List<Task> =
    remoteDataSource.fetchTasks().mapNotNull { it.toTask() }
}