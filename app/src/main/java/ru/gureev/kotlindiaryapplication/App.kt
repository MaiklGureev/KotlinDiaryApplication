package ru.gureev.kotlindiaryapplication

import android.app.Application
import ru.gureev.kotlindiaryapplication.di.AppComponent
import ru.gureev.kotlindiaryapplication.di.AppModule
import ru.gureev.kotlindiaryapplication.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger2()
    }

    fun initDagger2() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }
}