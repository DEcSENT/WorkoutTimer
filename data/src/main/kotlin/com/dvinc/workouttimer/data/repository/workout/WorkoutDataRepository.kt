/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.workout

import com.dvinc.workouttimer.data.database.WorkoutDatabase
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class WorkoutDataRepository @Inject constructor(
        private val workoutDatabase: WorkoutDatabase,
        private val workoutMapper: WorkoutMapper
) : WorkoutRepository {

    override fun obtainWorkouts(): Flowable<List<Workout>> {
        return Flowable.zip(
                workoutDatabase.workoutDao().getWorkouts(),
                workoutDatabase.exerciseDao().getAllExercises(),
                BiFunction { workouts, exercises ->
                    workouts.map { workout ->
                        workoutMapper.fromEntityToDomain(
                                workout,
                                exercises.filter { it.workoutId == workout.id })
                    }
                })
    }
}
