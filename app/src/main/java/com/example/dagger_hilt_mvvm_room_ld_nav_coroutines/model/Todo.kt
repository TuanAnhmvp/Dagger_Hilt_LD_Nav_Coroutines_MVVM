package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var todoTitle: String = ""
)