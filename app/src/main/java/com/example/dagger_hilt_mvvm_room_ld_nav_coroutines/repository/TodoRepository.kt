package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.repository

import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.db.TodoDao
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo
import javax.inject.Inject


class TodoRepository @Inject constructor(private val dao: TodoDao){
    suspend fun insertTodo(todo: Todo) = dao.insertTodo(todo)

    fun getAllTodo() = dao.getAllToDos()
}