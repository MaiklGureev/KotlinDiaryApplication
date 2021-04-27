package ru.gureev.kotlindiaryapplication.domain

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
        var text = StringBuilder()
        var counter = 1
        listTasks.forEach { task ->
            text.append("$counter. ${task.name} \n Description: ${task.description}")
            if (counter != listTasks.size) text.append("\n")
            counter++
        }
        return text.toString()
    }

}