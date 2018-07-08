/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.presentation.model.workout.WorkoutUi
import com.dvinc.circlestimer.presentation.ui.base.BaseMvpView
import com.dvinc.circlestimer.presentation.ui.base.MessageView

interface WorkoutView : BaseMvpView, MessageView {

    fun showWorkouts(workouts: List<Workout>)

    fun showDeleteWorkoutDialog(workout: Workout)

    fun showNewWorkoutDialog()
}
