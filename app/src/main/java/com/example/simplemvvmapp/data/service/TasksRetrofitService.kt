package com.example.simplemvvmapp.data.service

import com.example.simplemvvmapp.data.model.TaskDTO
import retrofit2.http.GET

interface TasksRetrofitService {

  @GET("todos")
  suspend fun loadTasks(): List<TaskDTO>

}