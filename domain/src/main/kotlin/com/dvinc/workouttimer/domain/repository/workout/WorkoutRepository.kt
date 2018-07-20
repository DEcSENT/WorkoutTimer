/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.repository.workout

import com.dvinc.workouttimer.domain.model.workout.Workout
import io.reactivex.Flowable

interface WorkoutRepository {

    fun obtainWorkouts(): Flowable<List<Workout>>
}
