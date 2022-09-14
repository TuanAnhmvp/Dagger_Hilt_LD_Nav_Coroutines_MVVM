package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)

abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

}