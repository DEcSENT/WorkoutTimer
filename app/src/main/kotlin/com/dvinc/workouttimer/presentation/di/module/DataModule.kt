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
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    companion object {
        private const val DATABASE_NAME = "workoutDb"
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): WorkoutDatabase {
        return Room.databaseBuilder(context, WorkoutDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideWorkoutDao(database: WorkoutDatabase): WorkoutDao {
        return database.workoutDao()
    }

    @Provides
    @Singleton
    fun provideExerciseDao(database: WorkoutDatabase): ExerciseDao {
        return database.exerciseDao()
    }
}
