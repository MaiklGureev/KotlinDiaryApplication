package ru.gureev.kotlindiaryapplication.domain

import kotlinx.coroutines.flow.Flow

interface TasksRepository {

    fun saveTask(task: Task)

    fun updateTask(task: Task)

    fun deleteTask(task: Task)

    fun loadTasks(): Flow<List<Task>>

}
