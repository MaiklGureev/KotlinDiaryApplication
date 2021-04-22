package ru.gureev.kotlindiaryapplication.domain

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class Task : RealmObject() {

    @PrimaryKey
    var id: ObjectId = ObjectId()

    @Required
    var name: String = ""

    @Required
    var description: String = ""

    var date_start: Long = System.currentTimeMillis()
    var date_finish: Long = System.currentTimeMillis()
}