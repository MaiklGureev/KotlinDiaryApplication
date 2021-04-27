package ru.gureev.kotlindiaryapplication.di

import dagger.Module
import dagger.Provides
import io.realm.Realm
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.gureev.kotlindiaryapplication.ProjectConfig
import ru.gureev.kotlindiaryapplication.data.TasksDAO
import ru.gureev.kotlindiaryapplication.data.TasksDAOImpl
import ru.gureev.kotlindiaryapplication.data.TasksRepositoryImpl
import ru.gureev.kotlindiaryapplication.domain.TasksRepository
import ru.gureev.kotlindiaryapplication.domain.mappers.TaskToTimeIntervalWithTasksMapper
import ru.gureev.kotlindiaryapplication.domain.use_cases.LoadTasksUseCase
import ru.gureev.kotlindiaryapplication.presentation.calendarandtasks.TimeIntervalAdapter

@Module
class ProviderModule {

    @Provides
    fun provideTasksDAO(): TasksDAO {
        return TasksDAOImpl()
    }

    @Provides
    fun provideRealm(): Realm {
        return Realm.getInstance(ProjectConfig.REALM_CONFIG)
    }

    @Provides
    fun provideTaskRepository(): TasksRepository {
        return TasksRepositoryImpl()
    }

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    @Provides
    fun provideTaskToTimeIntervalWithTasksMapper(): TaskToTimeIntervalWithTasksMapper {
        return TaskToTimeIntervalWithTasksMapper()
    }

    @Provides
    fun provideTimeIntervalAdapter(taskToTimeIntervalWithTasksMapper: TaskToTimeIntervalWithTasksMapper): TimeIntervalAdapter {
        return TimeIntervalAdapter(taskToTimeIntervalWithTasksMapper)
    }

    @Provides
    fun provideLoadTimeIntervalsWithTasksUseCase(
        tasksRepository: TasksRepository,
        dispatcher: CoroutineDispatcher
    ): LoadTasksUseCase {
        return LoadTasksUseCase(tasksRepository, dispatcher)
    }

//    @Provides
//    fun provideClassB(): ClassB {
//        return ClassB()
//    }
//
//    @Provides
//    fun provideClassA(classB: ClassB): ClassA {
//        return ClassA(classB)
//    }
}