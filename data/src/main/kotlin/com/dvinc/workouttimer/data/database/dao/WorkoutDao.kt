/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.dvinc.workouttimer.data.model.workout.WorkoutEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface WorkoutDao : BaseDao<WorkoutEntity> {

    @Query("SELECT * FROM workout")
    fun getWorkouts(): Flowable<List<WorkoutEntity>>

    @Query("SELECT * FROM workout WHERE id = :id")
    fun getWorkoutById(id: Int): Single<WorkoutEntity>

    @Query("DELETE FROM workout WHERE id = :id")
    fun deleteWorkoutById(id: Int)

    @Query("SELECT * FROM workout WHERE active = 1")
    fun getActiveWorkout(): Maybe<WorkoutEntity>
}