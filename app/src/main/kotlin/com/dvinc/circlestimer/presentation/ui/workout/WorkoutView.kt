/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import com.dvinc.circlestimer.presentation.model.workout.Workout
import com.dvinc.circlestimer.presentation.ui.base.BaseMvpView

interface WorkoutView : BaseMvpView {

    fun showWorkouts(workouts: List<Workout>)
}
