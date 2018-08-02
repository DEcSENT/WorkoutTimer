/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.workout

import com.dvinc.workouttimer.data.database.dao.WorkoutDao
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Flowable
import javax.inject.Inject

class WorkoutDataRepository @Inject constructor(
        private val workoutDao: WorkoutDao,
        private val workoutMapper: WorkoutMapper
) : WorkoutRepository {

    override fun obtainWorkouts(): Flowable<List<Workout>> {
        return workoutDao.getWorkouts()
                .map { workoutMapper.fromEntityToDomain(it) }
    }
}
