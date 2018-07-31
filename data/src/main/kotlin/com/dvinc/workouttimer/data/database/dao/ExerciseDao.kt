/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import io.reactivex.Flowable

@Dao
abstract class ExerciseDao {

    @Insert
    abstract fun addExercises(exercises: List<ExerciseEntity>)

    @Query("SELECT * FROM exercise WHERE workout_id = :id")
    abstract fun getExercisesByWorkoutId(id: Int): Flowable<List<ExerciseEntity>>
}
 