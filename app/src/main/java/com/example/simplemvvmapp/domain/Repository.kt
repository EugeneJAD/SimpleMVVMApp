package com.example.simplemvvmapp.domain

import com.example.simplemvvmapp.domain.model.Task

interface Repository {

    suspend fun loadTasks(): List<Task>
}