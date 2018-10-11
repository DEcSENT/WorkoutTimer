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
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.model.workout.WorkoutEntity

@Database(entities = [(WorkoutEntity::class), (ExerciseEntity::class)], version = 1)
@TypeConverters(ExerciseTypeConverter::class)
abstract class WorkoutDatabase : RoomDatabase() {

    abstract fun workoutDao(): WorkoutDao

    abstract fun exerciseDao(): ExerciseDao
}
