package ru.gureev.kotlindiaryapplication.data

import io.realm.Realm
import io.realm.kotlin.toFlow
import io.realm.kotlin.where
import kotlinx.coroutines.flow.Flow
import ru.gureev.kotlindiaryapplication.ProjectConfig
import ru.gureev.kotlindiaryapplication.domain.Task

class TasksDAOImpl : TasksDAO {

    override fun save(task: Task) {
        val realm = Realm.getInstance(ProjectConfig.REALM_CONFIG)
        realm.use {
            it.beginTransaction()
            it.insert(task)
            it.commitTransaction()
            it.close()
        }
    }

    override fun update(task: Task) {
        val realm = Realm.getInstance(ProjectConfig.REALM_CONFIG)
        realm.use {
            it.beginTransaction()
            it.insertOrUpdate(task)
            it.commitTransaction()
            it.close()
        }
    }

    override fun delete(task: Task) {
        val realm = Realm.getInstance(ProjectConfig.REALM_CONFIG)
        realm.use {
            it.beginTransaction()
            it.where<Task>().equalTo("id", task.id).findFirst()?.deleteFromRealm()
            it.commitTransaction()
            it.close()
        }
    }

    override fun getAll(): Flow<List<Task>> {
        val realm = Realm.getInstance(ProjectConfig.REALM_CONFIG)
        return realm.where<Task>().findAllAsync().toFlow()
    }

}