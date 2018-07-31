/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.dvinc.workouttimer.data.model.workout.WorkoutEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class WorkoutDao {

    @Insert
    abstract fun addWorkout(workout: WorkoutEntity)

    @Query("SELECT * FROM workout")
    abstract fun getWorkouts(): Flowable<List<WorkoutEntity>>

    @Query("SELECT * FROM workout WHERE id = :workoutId")
    abstract fun getWorkoutById(workoutId: Int): Single<WorkoutEntity>
}
 