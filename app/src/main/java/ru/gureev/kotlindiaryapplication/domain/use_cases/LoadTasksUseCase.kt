package ru.gureev.kotlindiaryapplication.domain.use_cases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.TasksRepository
import javax.inject.Inject


class LoadTasksUseCase @Inject constructor(
    private val tasksRepository: TasksRepository,
    private val dispatcher: CoroutineDispatcher
) {

    var tasksFlow: Flow<List<Task>> = flow {
        tasksRepository.loadTasks().flowOn(dispatcher).collect {
            emit(it)
        }
    }


}