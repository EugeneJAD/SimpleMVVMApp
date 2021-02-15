package com.example.simplemvvmapp.data.remote

import com.example.simplemvvmapp.data.model.TaskDTO
import com.example.simplemvvmapp.data.service.TasksRetrofitService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: TasksRetrofitService) {

  suspend fun fetchTasks(): List<TaskDTO> = service.loadTasks()

}