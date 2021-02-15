package com.example.simplemvvmapp.data

import timber.log.Timber
import javax.inject.Inject

class DataRepository @Inject constructor(): Repository {

    override fun loadTasks() {
        Timber.tag("loadTasks").d("loadTasks")
    }
}