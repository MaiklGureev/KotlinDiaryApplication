package ru.gureev.kotlindiaryapplication.domain

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId
import java.util.*

open class Task : RealmObject() {

    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name: String = ""
    var description: String = ""
    var date_start: Long = 0
    var date_finish: Long = 0

    override fun toString(): String {
        return "Task(id=$id, name='$name', description='$description', date_start=${Date(date_start)}, date_finish=${
            Date(
                date_finish
            )
        })\n"
    }

}