/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repository.workout

import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Flowable

class WorkoutDataRepository : WorkoutRepository {

    override fun obtainWorkouts(): Flowable<List<Workout>> {
        return Flowable.fromArray(generateMocks())
    }

    private fun generateMocks(): List<Workout> {
        val list = ArrayList<Workout>()

        (1..7).forEach {
            list.add(Workout(it, "Workout$it", 10, 100000, false))
        }

        return list
    }
}
