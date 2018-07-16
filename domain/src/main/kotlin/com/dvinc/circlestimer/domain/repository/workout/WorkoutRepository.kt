/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.repository.workout

import com.dvinc.circlestimer.domain.model.workout.Workout
import io.reactivex.Flowable

interface WorkoutRepository {

    fun obtainWorkouts(): Flowable<List<Workout>>
}
