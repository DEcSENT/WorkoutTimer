/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import com.dvinc.circlestimer.presentation.model.workout.Workout
import com.dvinc.circlestimer.presentation.ui.base.BasePresenter

class WorkoutPresenter : BasePresenter<WorkoutView>() {

    //TODO: Inject interactor

    fun initWorkoutView() {
        //TODO: load workouts here
    }

    fun onItemSwiped(workout: Workout)  {
        //TODO: call delete dialog
    }

    fun onWorkoutDeleted(workout: Workout) {
        //TODO: delete workout. And rename this method?
    }
}
