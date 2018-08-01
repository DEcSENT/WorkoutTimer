/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface ExerciseDao {

    @Insert
    fun addExercises(exercises: List<ExerciseEntity>)

    @Insert
    fun addExercise(exercise: ExerciseEntity)

    @Update
    fun updateExerciseById(exercise: ExerciseEntity)

    @Query("SELECT * FROM exercise")
    fun getAllExercises(): Flowable<List<ExerciseEntity>>

    @Query("SELECT * FROM exercise WHERE workout_id = :id")
    fun getExercisesByWorkoutId(id: Int): Flowable<List<ExerciseEntity>>

    @Query("SELECT * FROM exercise WHERE id = :id")
    fun getExerciseById(id: Int): Single<ExerciseEntity>

    @Query("DELETE FROM exercise WHERE id = :id")
    fun deleteExerciseById(id: Int)
}
