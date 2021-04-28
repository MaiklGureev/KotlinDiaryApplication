package ru.gureev.kotlindiaryapplication.domain

import java.text.SimpleDateFormat
import java.util.*

class TimeIntervalWithTasks {
    var currentNum: Int = 0
    lateinit var timeStart: Calendar
    lateinit var timeFinish: Calendar
    var listTasks: MutableList<Task> = arrayListOf()

    override fun toString(): String {
        return "TimeIntervalWithTasks(currentNum=$currentNum, timeIntervalStart=${timeStart.time}, timeIntervalStop=${timeFinish.time}, listTasks=${listTasks.size})"
    }

    fun getFormattedTasks(): String {
        val text = StringBuilder()
        var counter = 1
        listTasks.forEach { task ->

            val timeStart =
                SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
                    .format(Calendar.getInstance().apply { timeInMillis = task.date_start }.time)
            val timeFinish =
                SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
                    .format(Calendar.getInstance().apply { timeInMillis = task.date_finish }.time)
            val time = "$timeStart - $timeFinish"

            text.append("$counter. ${task.name} \nTime: $time \nDescription:${task.description}")
            if (counter != listTasks.size) text.append("\n")
            counter++

        }
        return text.toString()
    }

}