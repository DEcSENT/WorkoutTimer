/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.workout

import com.dvinc.workouttimer.data.database.dao.WorkoutDao
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class WorkoutDataRepository @Inject constructor(
        private val workoutDao: WorkoutDao,
        private val workoutMapper: WorkoutMapper
) : WorkoutRepository {

    override fun obtainWorkouts(): Flowable<List<Workout>> {
        return workoutDao.getWorkouts()
                .map { workoutMapper.fromEntity(it) }
    }

    override fun obtainActiveWorkout(): Maybe<Workout> {
        return workoutDao.getActiveWorkout()
                .map { workoutMapper.fromEntity(it) }
    }

    override fun addWorkout(workout: Workout): Completable {
        return Single.fromCallable { workoutMapper.fromDomain(workout) }
                .flatMapCompletable { Completable.fromAction { workoutDao.insert(it) } }
    }

    override fun deleteWorkoutById(id: Int): Completable {
        return Completable.fromAction { workoutDao.deleteWorkoutById(id) }
    }
}
