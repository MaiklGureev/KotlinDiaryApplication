package ru.gureev.kotlindiaryapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import ru.gureev.kotlindiaryapplication.ProjectConfig
import javax.inject.Singleton

@Module
class AppModule(private var applicationContext: Context) {

    init {
        Realm.init(applicationContext)
        Realm.setDefaultConfiguration(ProjectConfig.REALM_CONFIG)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return applicationContext
    }

}