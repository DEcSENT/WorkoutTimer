/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.dvinc.workouttimer.data.database.dao.ExerciseDao
import com.dvinc.workouttimer.data.database.dao.WorkoutDao
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.model.workout.WorkoutEntity

@Database(entities = [(WorkoutEntity::class), (ExerciseEntity::class)], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {

    abstract fun workoutDao(): WorkoutDao

    abstract fun exerciseDao(): ExerciseDao
}
 