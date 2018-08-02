/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.dvinc.workouttimer.data.database.WorkoutDatabase
import com.dvinc.workouttimer.data.database.dao.ExerciseDao
import com.dvinc.workouttimer.data.database.dao.WorkoutDao
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseDataMapper
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutDataMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.data.repository.exercise.mock.ExerciseDataRepositoryMock
import com.dvinc.workouttimer.data.repository.workout.mock.WorkoutDataRepositoryMock
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

//TODO: Refactor this module when old DI will be deleted
@Module
abstract class NewApplicationModule {

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepositoryMock): WorkoutRepository

    @Binds
    abstract fun provideExerciseRepository(repository: ExerciseDataRepositoryMock): ExerciseRepository

    @Binds
    abstract fun provideWorkoutMapper(mapper: WorkoutDataMapper): WorkoutMapper

    @Binds
    abstract fun provideExerciseMapper(mapper: ExerciseDataMapper): ExerciseMapper

    @Module
    companion object {

        @Provides
        @JvmStatic
        internal fun provideDatabase(context: Context): WorkoutDatabase =
                Room.databaseBuilder(context, WorkoutDatabase::class.java, "workoutDb").build()

        @Provides
        @JvmStatic
        internal fun provideWorkoutDao(database: WorkoutDatabase): WorkoutDao {
            return database.workoutDao()
        }

        @Provides
        @JvmStatic
        internal fun provideExerciseDao(database: WorkoutDatabase): ExerciseDao {
            return database.exerciseDao()
        }
    }
}
