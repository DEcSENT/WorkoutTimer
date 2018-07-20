/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.workout

import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.usecase.workout.WorkoutUseCase
import com.dvinc.workouttimer.presentation.mapper.workout.WorkoutPresentationMapper
import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.dvinc.workouttimer.presentation.ui.base.BasePresenter
import javax.inject.Inject

class WorkoutPresenter @Inject constructor(
        private val workoutUseCase: WorkoutUseCase,
        private val mapper: WorkoutPresentationMapper
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
    fun onWorkoutClick(workout: WorkoutUi) {
        addSubscription(workoutUseCase.selectActiveWorkout(workout.id)
                .subscribe(
                        {},
                        { it.toString() }))
    }

    //TODO: handle error
    private fun initWorkoutView() {
        addSubscription(workoutUseCase.obtainWorkouts()
                .map { mapper.mapDomainToUi(it) }
                .subscribe(
                        { getView()?.showWorkouts(it) },
                        { it.printStackTrace() }
                ))
    }
}
