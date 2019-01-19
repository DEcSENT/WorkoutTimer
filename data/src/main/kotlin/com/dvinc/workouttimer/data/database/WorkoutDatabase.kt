/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dvinc.workouttimer.data.database.converter.ExerciseTypeConverter
import com.dvinc.workouttimer.data.database.dao.ExerciseDao
import com.dvinc.workouttimer.data.database.dao.WorkoutDao
import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutEntity

@Database(
        entities = [(WorkoutEntity::class), (ExerciseEntity::class)],
        version = WorkoutDatabase.DATABASE_VERSION,
        exportSchema = false)
@TypeConverters(ExerciseTypeConverter::class)
abstract class WorkoutDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun workoutDao(): WorkoutDao

    abstract fun exerciseDao(): ExerciseDao
}
