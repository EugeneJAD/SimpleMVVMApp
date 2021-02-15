package com.example.simplemvvmapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemvvmapp.data.DataRepository
import com.example.simplemvvmapp.domain.model.Task
import com.example.simplemvvmapp.utils.CoroutinesDispatcherProvider
import com.example.simplemvvmapp.utils.DispatcherProvider
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class HomeViewModel @Inject constructor(
  private val repository: DataRepository,
  private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

  private val _uiState = MutableLiveData<UIState<List<Task>>>()
  val uiState: LiveData<UIState<List<Task>>> get() = _uiState

  init {
    loadData()
  }

  private fun loadData() {
    emitUIState(UIState.Loading)
    viewModelScope.launch(dispatcherProvider.main) {
      try {
        val result = withContext(dispatcherProvider.io) { repository.loadTasks() }
        emitUIState(UIState.Success(result))
      } catch (e: Exception) {
        emitUIState(UIState.Error(e))
      }
    }
  }

  private fun emitUIState(state: UIState<List<Task>>) {
    _uiState.value = state
  }
}

// Option 1
sealed class UIState<out T> {
  object Loading : UIState<Nothing>()
  data class Success<out T>(val data: T) : UIState<T>()
  data class Error(val cause: Exception) : UIState<Nothing>()
}

// Option 2
data class ViewState(
  val loading: Boolean = false,
  val error: Exception? = null,
  val data: List<Task>
)