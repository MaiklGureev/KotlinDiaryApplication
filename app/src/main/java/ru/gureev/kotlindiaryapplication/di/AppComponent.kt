package ru.gureev.kotlindiaryapplication.di

import dagger.Component
import ru.gureev.kotlindiaryapplication.MainActivity
import ru.gureev.kotlindiaryapplication.data.TasksRepositoryImpl
import ru.gureev.kotlindiaryapplication.domain.use_cases.LoadTasksUseCase
import ru.gureev.kotlindiaryapplication.presentation.calendarandtasks.CalendarAndTasksFragment
import ru.gureev.kotlindiaryapplication.presentation.calendarandtasks.CalendarAndTasksViewModel
import javax.inject.Singleton

@Component(modules = [AppModule::class, ProviderModule::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(repository: TasksRepositoryImpl)

    fun inject(loadTasksUseCase: LoadTasksUseCase)

    fun inject(viewModel: CalendarAndTasksViewModel)
    fun inject(fragment: CalendarAndTasksFragment)
}