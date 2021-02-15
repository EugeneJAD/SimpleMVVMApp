package com.example.simplemvvmapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.simplemvvmapp.data.DataRepository
import javax.inject.Inject


class HomeViewModel @Inject constructor(
        private val repository: DataRepository
) : ViewModel() {

    init {
        loadData()
    }

    fun loadData() {
        repository.loadTasks()
    }
}