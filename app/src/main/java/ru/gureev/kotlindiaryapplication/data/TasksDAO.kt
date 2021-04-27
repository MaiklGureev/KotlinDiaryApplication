package ru.gureev.kotlindiaryapplication.data

import kotlinx.coroutines.flow.Flow
import ru.gureev.kotlindiaryapplication.domain.Task

interface TasksDAO {
    fun save(task: Task)

    fun update(task: Task)

    fun delete(task: Task)

    fun getAll(): Flow<List<Task>>
}