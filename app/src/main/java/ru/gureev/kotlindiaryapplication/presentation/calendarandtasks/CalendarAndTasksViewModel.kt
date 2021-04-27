package ru.gureev.kotlindiaryapplication.presentation.calendarandtasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.gureev.kotlindiaryapplication.App
import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.mappers.TaskToTimeIntervalWithTasksMapper
import ru.gureev.kotlindiaryapplication.domain.use_cases.LoadTasksUseCase
import javax.inject.Inject


class CalendarAndTasksViewModel : ViewModel() {

    private val TAG = "CalendarAndTasksViewModel"

    @Inject
    lateinit var loadTasksUseCase: LoadTasksUseCase

    @Inject
    lateinit var taskToTimeIntervalWithTasksMapper: TaskToTimeIntervalWithTasksMapper

    var tasksListFlow: LiveData<List<Task>>

    init {
        App.appComponent.inject(this)
        tasksListFlow = loadTasksUseCase.tasksFlow.asLiveData()
    }

}