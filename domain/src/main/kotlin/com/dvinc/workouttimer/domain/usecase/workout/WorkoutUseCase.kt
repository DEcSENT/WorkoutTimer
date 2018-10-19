/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.usecase.workout

import com.dvinc.workouttimer.domain.common.execution.ThreadScheduler
import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

class WorkoutUseCase @Inject constructor(
        private val threadScheduler: ThreadScheduler,
        private val workoutRepository: WorkoutRepository
) {

    fun obtainWorkouts(): Flowable<List<Workout>> {
        return workoutRepository.obtainWorkouts()
                .compose(threadScheduler.ioToUiFlowable())
    }

    fun selectActiveWorkout(workoutId: Int): Completable {
        return workoutRepository.makeWorkoutActiveById(workoutId)
                .compose(threadScheduler.ioToUiCompletable())
    }

    fun deleteWorkoutById(id: Int): Completable {
        return workoutRepository.deleteWorkoutById(id)
                .compose(threadScheduler.ioToUiCompletable())
    }

    fun obtainActiveWorkout(): Maybe<Workout> {
        return workoutRepository.obtainActiveWorkout()
                .compose(threadScheduler.ioToUiMaybe())
    }
}
