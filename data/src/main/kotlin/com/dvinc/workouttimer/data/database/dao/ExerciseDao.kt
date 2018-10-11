/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface ExerciseDao : BaseDao<ExerciseEntity> {

    @Query("SELECT * FROM exercise")
    fun getAllExercises(): Flowable<List<ExerciseEntity>>

    @Query("SELECT * FROM exercise WHERE workout_id = :id")
    fun getExercisesByWorkoutId(id: Int): Flowable<List<ExerciseEntity>>

    @Query("SELECT * FROM exercise WHERE id = :id")
    fun getExerciseById(id: Int): Single<ExerciseEntity>

    @Query("DELETE FROM exercise WHERE id = :id")
    fun deleteExerciseById(id: Int)
}
