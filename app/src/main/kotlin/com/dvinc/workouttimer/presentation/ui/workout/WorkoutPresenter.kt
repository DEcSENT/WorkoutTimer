/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.workout

import com.dvinc.workouttimer.domain.usecase.workout.WorkoutUseCase
import com.dvinc.workouttimer.presentation.mapper.workout.WorkoutPresentationMapper
import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.dvinc.workouttimer.presentation.ui.base.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class WorkoutPresenter @Inject constructor(
        private val workoutUseCase: WorkoutUseCase,
        private val mapper: WorkoutPresentationMapper
) : BasePresenter<WorkoutView>() {

    override fun attachView(view: WorkoutView) {
        super.attachView(view)
        initWorkoutView()
    }

    fun onAddButtonClick() {
        getView()?.showNewWorkoutDialog()
    }

    fun onWorkoutDeleted(workoutId: Int) {
        addSubscription(workoutUseCase.deleteWorkoutById(workoutId)
                .subscribe(
                        { /* TODO: Show message here */ },
                        { Timber.e(it) }
                ))
    }

    fun onWorkoutClick(workout: WorkoutUi) {
        addSubscription(workoutUseCase.selectActiveWorkout(workout.id)
                .subscribe(
                        {},
                        { Timber.e(it) }))
    }

    private fun initWorkoutView() {
        addSubscription(workoutUseCase.obtainWorkouts()
                .map { mapper.mapDomainToUi(it) }
                .subscribe(
                        { getView()?.showWorkouts(it) },
                        { Timber.e(it) }
                ))
    }
}
