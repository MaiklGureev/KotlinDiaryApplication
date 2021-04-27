package ru.gureev.kotlindiaryapplication.domain.mappers

import junit.framework.TestCase
import ru.gureev.kotlindiaryapplication.domain.Task
import java.util.*

class TaskToTimeIntervalWithTasksMapperTest : TestCase() {

    private val mapper: TaskToTimeIntervalWithTasksMapper = TaskToTimeIntervalWithTasksMapper()
    private val currentDate = Calendar.getInstance()

    fun testInitIntervals() {
        mapper.initIntervals(currentDate)

        assertEquals(mapper.timeIntervalWithTasks.size, 24)

        assertEquals(
            currentDate.get(Calendar.YEAR),
            mapper.timeIntervalWithTasks[0].timeStart.get(Calendar.YEAR)
        )
        assertEquals(
            currentDate.get(Calendar.MONTH),
            mapper.timeIntervalWithTasks[0].timeStart.get(Calendar.MONTH)
        )
        assertEquals(
            currentDate.get(Calendar.DAY_OF_MONTH),
            mapper.timeIntervalWithTasks[0].timeStart.get(Calendar.DAY_OF_MONTH)
        )

        assertEquals(mapper.timeIntervalWithTasks[0].timeStart.get(Calendar.HOUR_OF_DAY), 0)
        assertEquals(mapper.timeIntervalWithTasks[0].timeFinish.get(Calendar.HOUR_OF_DAY), 1)

        assertEquals(mapper.timeIntervalWithTasks[23].timeStart.get(Calendar.HOUR_OF_DAY), 23)
        assertEquals(mapper.timeIntervalWithTasks[23].timeFinish.get(Calendar.HOUR_OF_DAY), 0)
    }

    fun testGroupTasksByTimeIntervals() {
        val list: MutableList<Task> = arrayListOf()
        mapper.initIntervals(currentDate)

        list.add(Task().apply {
            name = "My task"
            description = "My description"
            date_start = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 1)
                set(Calendar.MINUTE, 10)
            }.timeInMillis
            date_finish = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 1)
                set(Calendar.MINUTE, 3)
            }.timeInMillis
        })

        list.add(Task().apply {
            name = "My task"
            description = "My description"
            date_start = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 4)
                set(Calendar.MINUTE, 0)
            }.timeInMillis
            date_finish = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 6)
                set(Calendar.MINUTE, 0)
            }.timeInMillis
        })

        mapper.groupTasksByTimeIntervals(list)

        assertEquals(mapper.timeIntervalWithTasks[0].listTasks.size, 0)
        assertEquals(mapper.timeIntervalWithTasks[1].listTasks.size, 1)
        assertEquals(mapper.timeIntervalWithTasks[0].listTasks.size, 0)

        assertEquals(mapper.timeIntervalWithTasks[3].listTasks.size, 0)
        assertEquals(mapper.timeIntervalWithTasks[4].listTasks.size, 1)
        assertEquals(mapper.timeIntervalWithTasks[5].listTasks.size, 1)
        assertEquals(mapper.timeIntervalWithTasks[6].listTasks.size, 1)
        assertEquals(mapper.timeIntervalWithTasks[7].listTasks.size, 0)


    }
}