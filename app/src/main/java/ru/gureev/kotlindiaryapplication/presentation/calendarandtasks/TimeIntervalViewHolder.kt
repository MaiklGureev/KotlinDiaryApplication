package ru.gureev.kotlindiaryapplication.presentation.calendarandtasks

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.gureev.kotlindiaryapplication.databinding.TimeIntervalItemBinding
import ru.gureev.kotlindiaryapplication.domain.TimeIntervalWithTasks
import java.text.SimpleDateFormat
import java.util.*

class TimeIntervalViewHolder(private val binding: TimeIntervalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "Click on time interval with tasks!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun bind(timeInterval: TimeIntervalWithTasks) {
        val timeStart =
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(timeInterval.timeStart.time)
        val timeFinish =
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(timeInterval.timeFinish.time)
        val text = "$timeStart - $timeFinish"
        binding.timeIntervalTextView.text = text
        val tasks = timeInterval.getFormattedTasks()
        binding.tasksTextView.text = tasks
    }


}