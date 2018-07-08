/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.domain.usecase.workout.WorkoutUseCase
import com.dvinc.circlestimer.presentation.ui.base.BasePresenter
import javax.inject.Inject

class WorkoutPresenter @Inject constructor(
        private val workoutUseCase: WorkoutUseCase
) : BasePresenter<WorkoutView>() {

    override fun attachView(view: WorkoutView) {
        super.attachView(view)
        initWorkoutView()
    }

    fun onItemSwiped(workout: Workout)  {
        //TODO: call delete dialog
    }

    fun onWorkoutDeleted(workout: Workout) {
        //TODO: delete workout. And rename this method?
    }

    //TODO: handle error
    private fun initWorkoutView() {
        addSubscription(workoutUseCase.obtainWorkouts()
                .subscribe(
                        { getView()?.showWorkouts(it) },
                        { it.printStackTrace() }
                ))
    }
}
