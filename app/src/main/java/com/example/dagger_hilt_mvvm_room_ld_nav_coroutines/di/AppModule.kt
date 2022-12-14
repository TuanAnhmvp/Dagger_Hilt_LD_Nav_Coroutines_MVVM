package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.di

import android.content.Context
import androidx.room.Room
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context)
    = Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db").build()

    @Singleton
    @Provides
    fun provideTodoDao(db: TodoDatabase) = db.todoDao()

}