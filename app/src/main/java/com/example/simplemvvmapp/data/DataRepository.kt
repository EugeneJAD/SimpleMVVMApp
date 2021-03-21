package com.example.simplemvvmapp.data

import com.example.simplemvvmapp.data.remote.RemoteDataSource
import com.example.simplemvvmapp.domain.Repository
import com.example.simplemvvmapp.domain.model.Task
import com.example.simplemvvmapp.domain.model.toTask
import com.example.simplemvvmapp.utils.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.Throws

@Singleton
class DataRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dispatcherProvider: DispatcherProvider
) : Repository {

    @Throws
    override suspend fun loadTasks(): List<Task> = withContext(dispatcherProvider.io) {
        remoteDataSource.fetchTasks().mapNotNull { it.toTask() }
    }
}
