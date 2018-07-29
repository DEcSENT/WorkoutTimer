/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import com.dvinc.workouttimer.domain.usecase.exercise.ExerciseUseCase
import com.dvinc.workouttimer.presentation.mapper.exercises.ExercisePresentationMapper
import com.dvinc.workouttimer.presentation.ui.base.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class ExercisePresenter @Inject constructor(
        private val exercisesUseCase: ExerciseUseCase,
        private val exerciseMapper: ExercisePresentationMapper
) : BasePresenter<ExerciseView>() {

    fun initView() {
        addSubscription(
                exercisesUseCase.obtainExercisesForCurrentWorkout()
                        .map { exerciseMapper.mapDomainToUi(it) }
                        .subscribe(
                                { getView()?.showExercises(it) },
                                { Timber.e(it) }
                        )
        )
    }
}
 