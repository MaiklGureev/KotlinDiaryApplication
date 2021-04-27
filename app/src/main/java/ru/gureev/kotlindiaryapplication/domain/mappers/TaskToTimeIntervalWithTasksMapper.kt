package ru.gureev.kotlindiaryapplication.domain.mappers

import ru.gureev.kotlindiaryapplication.domain.Task
import ru.gureev.kotlindiaryapplication.domain.TimeIntervalWithTasks
import java.util.*

class TaskToTimeIntervalWithTasksMapper {

    var timeIntervalWithTasks: MutableList<TimeIntervalWithTasks> = arrayListOf()

    fun initIntervals(currentDate: Calendar) {

        timeIntervalWithTasks.clear()

        for (i in 0..23) {
            timeIntervalWithTasks.add(
                TimeIntervalWithTasks().also {
                    it.currentNum = i
                    it.timeStart = currentDate.clone() as Calendar
                    it.timeFinish = currentDate.clone() as Calendar

                    it.timeStart.set(Calendar.HOUR_OF_DAY, i)
                    it.timeStart.set(Calendar.MINUTE, 0)
                    it.timeStart.set(Calendar.SECOND, 0)
                    it.timeStart.set(Calendar.MILLISECOND, 0)

                    it.timeFinish.set(Calendar.HOUR_OF_DAY, i + 1)
                    it.timeFinish.set(Calendar.MINUTE, 0)
                    it.timeFinish.set(Calendar.SECOND, 0)
                    it.timeFinish.set(Calendar.MILLISECOND, 0)
                }
            )
        }
    }

    private fun clearTasksInIntervals() {
        timeIntervalWithTasks.let {
            for (interval in timeIntervalWithTasks) {
                interval.listTasks.clear()
            }
        }
    }


    fun groupTasksByTimeIntervals(listTasks: List<Task>): List<TimeIntervalWithTasks> {
        clearTasksInIntervals()

        for (task in listTasks) {

            val taskTimeStart: Calendar = Calendar.getInstance().apply {
                timeInMillis = task.date_start
            }

            val taskTimeFinish: Calendar = Calendar.getInstance().apply {
                timeInMillis = task.date_finish
            }

            for (timeInterval in timeIntervalWithTasks) {
                when {
                    ((taskTimeStart.after(timeInterval.timeStart) && taskTimeFinish.before(
                        timeInterval.timeFinish
                    ))) -> {
                        timeInterval.listTasks.add(task)
                    }


                    ((taskTimeStart.equals(timeInterval.timeStart) && taskTimeFinish.equals(
                        timeInterval.timeFinish
                    ))) -> {
                        timeInterval.listTasks.add(task)
                    }

                    ((taskTimeStart.equals(timeInterval.timeStart) && (taskTimeFinish.after(
                        timeInterval.timeStart
                    )) && taskTimeFinish.after(timeInterval.timeFinish))) -> {
                        timeInterval.listTasks.add(task)
                    }

                    (timeInterval.timeStart.before(taskTimeStart) && timeInterval.timeFinish.after(
                        taskTimeStart
                    ) && timeInterval.timeFinish.before(taskTimeFinish)) -> {
                        timeInterval.listTasks.add(task)
                    }

                    ((taskTimeStart.before(timeInterval.timeStart) && taskTimeFinish.after(
                        timeInterval.timeStart
                    ))
                            ) -> {
                        timeInterval.listTasks.add(task)
                    }

                    ((taskTimeStart.before(timeInterval.timeFinish) && taskTimeFinish.equals(
                        timeInterval.timeFinish
                    ))
                            ) -> {
                        timeInterval.listTasks.add(task)
                    }

                    (taskTimeStart.before(timeInterval.timeStart)
                            && taskTimeFinish.after(timeInterval.timeFinish)
                            && !taskTimeFinish.equals(timeInterval.timeFinish)
                            && !taskTimeStart.equals(timeInterval.timeStart)
                            ) -> {
                        timeInterval.listTasks.add(task)
                    }
                }
            }

        }
        return timeIntervalWithTasks
    }
}