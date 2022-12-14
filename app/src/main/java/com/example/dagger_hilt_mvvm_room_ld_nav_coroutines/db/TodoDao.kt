package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.db

import androidx.room.*
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Query("SELECT * FROM todo ORDER BY todoTitle ASC")
    fun getAllToDos(): Flow<List<Todo>>

    @Delete()
    suspend fun deleteToDo(todo: Todo)
}