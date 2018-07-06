/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.usecase.workout

import com.dvinc.circlestimer.domain.common.extension.getIoToMainTransformerFlowable
import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Flowable
import javax.inject.Inject

class WorkoutUseCase @Inject constructor(
        private val workoutRepository: WorkoutRepository
) {

    fun obtainWorkouts(): Flowable<List<Workout>>{
        return workoutRepository.obtainWorkouts()
                .compose(getIoToMainTransformerFlowable())
    }
}
 