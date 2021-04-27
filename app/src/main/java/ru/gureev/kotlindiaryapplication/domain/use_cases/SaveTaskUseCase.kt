package ru.gureev.kotlindiaryapplication.domain.use_cases

import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.TasksRepository
import javax.inject.Inject


class SaveTaskUseCase @Inject constructor(
    private val tasksRepository: TasksRepository,
) {

    fun saveTask(task: Task) {
        tasksRepository.saveTask(task)
    }


}