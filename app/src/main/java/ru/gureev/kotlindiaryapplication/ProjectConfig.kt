package ru.gureev.kotlindiaryapplication

import io.realm.RealmConfiguration

object ProjectConfig {

    private const val REALM_NAME = "TasksDataBase"

    val REALM_CONFIG: RealmConfiguration = RealmConfiguration.Builder()
        .name(this.REALM_NAME)
        .allowQueriesOnUiThread(true)
        .allowWritesOnUiThread(true)
        .build()

}