package ru.gureev.kotlindiaryapplication.di

import dagger.Component
import ru.gureev.kotlindiaryapplication.MainActivity
import javax.inject.Singleton

@Component(modules = [AppModule::class, ProviderModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
}