package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository): ViewModel() {

    fun insertTodo(todo: Todo) = viewModelScope.launch {
        todoRepository.insertTodo(todo)
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch {
        todoRepository.deleteToDo(todo)
    }

    val getAllToDos = todoRepository.getAllTodo().asLiveData()


}