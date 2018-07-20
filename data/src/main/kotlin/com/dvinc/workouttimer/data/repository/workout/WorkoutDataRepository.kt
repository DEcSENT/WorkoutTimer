/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.workout

import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Flowable

class WorkoutDataRepository : WorkoutRepository {

    override fun obtainWorkouts(): Flowable<List<Workout>> {
        return Flowable.fromArray(generateMocks())
    }

    private fun generateMocks(): List<Workout> {
        val list = ArrayList<Workout>()

        (1..7).forEach {
            list.add(Workout(it, "Workout$it", "Hilarious workout with girls, beer, and thousands exercises", 10, 100000, false))
        }

        return list
    }
}
