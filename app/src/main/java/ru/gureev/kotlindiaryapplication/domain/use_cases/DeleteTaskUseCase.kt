package ru.gureev.kotlindiaryapplication.domain.use_cases

import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.TasksRepository
import javax.inject.Inject


class DeleteTaskUseCase @Inject constructor(
    private val tasksRepository: TasksRepository,
) {


    fun deleteTask(task: Task) {
        tasksRepository.deleteTask(task)
    }


}