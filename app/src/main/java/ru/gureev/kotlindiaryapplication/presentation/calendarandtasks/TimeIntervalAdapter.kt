package ru.gureev.kotlindiaryapplication.presentation.calendarandtasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gureev.kotlindiaryapplication.databinding.TimeIntervalItemBinding
import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.TimeIntervalWithTasks
import ru.gureev.kotlindiaryapplication.domain.mappers.TaskToTimeIntervalWithTasksMapper
import java.util.*
import javax.inject.Inject

class TimeIntervalAdapter @Inject constructor(
    private val mapper: TaskToTimeIntervalWithTasksMapper
) : RecyclerView.Adapter<TimeIntervalViewHolder>() {

    private var timeIntervalWithTasksList: List<TimeIntervalWithTasks> = emptyList()
    private var tasksList: List<Task> = emptyList()
    private var currentDate: Calendar = Calendar.getInstance()

    fun updateTasksList(list: List<Task>) {
        tasksList = list
        mapper.initIntervals(currentDate)
        timeIntervalWithTasksList = mapper.groupTasksByTimeIntervals(list)
        notifyDataSetChanged()
    }

    fun changeCurrentDate(newDate: Calendar) {
        currentDate = newDate
        updateTasksList(tasksList)
    }

    override fun onBindViewHolder(holder: TimeIntervalViewHolder, position: Int) {
        val timeIntervalWithTask = timeIntervalWithTasksList[position]
        holder.bind(timeIntervalWithTask)
    }

    override fun getItemCount(): Int {
        return timeIntervalWithTasksList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeIntervalViewHolder {
        return TimeIntervalViewHolder(
            TimeIntervalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}