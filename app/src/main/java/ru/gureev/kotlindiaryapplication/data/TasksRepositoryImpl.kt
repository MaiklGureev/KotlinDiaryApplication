package ru.gureev.kotlindiaryapplication.data

import kotlinx.coroutines.flow.Flow
import ru.gureev.kotlindiaryapplication.App
import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.TasksRepository
import javax.inject.Inject

class TasksRepositoryImpl : TasksRepository {

    @Inject
    lateinit var tasksDAO: TasksDAO

    init {
        App.appComponent.inject(this)
    }


    override fun saveTask(task: Task) {
        return tasksDAO.save(task)
    }


    override fun updateTask(task: Task) {
        return tasksDAO.update(task)
    }


    override fun deleteTask(task: Task) {
        return tasksDAO.delete(task)
    }

    override fun loadTasks(): Flow<List<Task>> {
        return tasksDAO.getAll()
    }
}