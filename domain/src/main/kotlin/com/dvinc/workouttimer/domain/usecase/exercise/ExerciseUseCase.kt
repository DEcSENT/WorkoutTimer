/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.usecase.exercise

import com.dvinc.workouttimer.domain.common.execution.ThreadScheduler
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import io.reactivex.Flowable
import javax.inject.Inject

class ExerciseUseCase @Inject constructor(
        private val threadScheduler: ThreadScheduler,
        private val exercisesRepository: ExerciseRepository
) {

    fun obtainExercisesForCurrentWorkout(): Flowable<List<Exercise>> {
        return exercisesRepository.obtainExercises()
                .compose(threadScheduler.ioToUiFlowable())
    }
}
