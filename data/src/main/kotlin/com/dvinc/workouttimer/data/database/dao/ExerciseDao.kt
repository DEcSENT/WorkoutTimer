/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity

@Dao
abstract class ExerciseDao {

    @Insert
    abstract fun addExercises(exercises: List<ExerciseEntity>)
}
 