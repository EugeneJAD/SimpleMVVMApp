package com.example.simplemvvmapp.domain.model

import com.example.simplemvvmapp.data.model.TaskDTO


data class Task(
  val id: Int,
  val userId: Int,
  val title: String,
  val completed: Boolean,
)

fun TaskDTO.toTask(): Task? = try {
  Task(
    id = checkNotNull(id),
    userId = checkNotNull(userId),
    title = title.orEmpty(),
    completed = completed ?: false
  )
} catch (e: IllegalStateException) {
  null
}