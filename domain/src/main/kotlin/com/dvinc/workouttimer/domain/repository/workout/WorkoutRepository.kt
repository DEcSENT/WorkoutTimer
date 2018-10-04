/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.repository.workout

import com.dvinc.workouttimer.domain.model.workout.Workout
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe

interface WorkoutRepository {

    fun obtainWorkouts(): Flowable<List<Workout>>

    fun obtainActiveWorkout(): Maybe<Workout>

    fun addWorkout(workout: Workout): Completable
}
