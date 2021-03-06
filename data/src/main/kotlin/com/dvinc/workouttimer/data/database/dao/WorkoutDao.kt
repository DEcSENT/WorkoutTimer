/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutEntity
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutWithExercisesWrapper
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface WorkoutDao : BaseDao<WorkoutEntity> {

    @Transaction
    @Query("SELECT * FROM workouts")
    fun getWorkouts(): Flowable<List<WorkoutWithExercisesWrapper>>

    @Transaction
    @Query("SELECT * FROM workouts WHERE uid = :id")
    fun getWorkoutById(id: Int): Single<WorkoutWithExercisesWrapper>

    @Transaction
    @Query("SELECT * FROM workouts WHERE active = 1")
    fun getActiveWorkout(): Maybe<WorkoutWithExercisesWrapper>

    @Query("DELETE FROM workouts WHERE uid = :id")
    fun deleteWorkoutById(id: Int)

    @Query("UPDATE workouts SET active = 1 WHERE uid = :workoutId")
    fun makeWorkoutActiveById(workoutId: Int)

    @Query("UPDATE workouts SET active = 0 WHERE active = 1")
    fun deactivateActiveWorkout()

    @Transaction
    fun activateWorkoutById(workoutId: Int) {
        deactivateActiveWorkout()
        makeWorkoutActiveById(workoutId)
    }
}
