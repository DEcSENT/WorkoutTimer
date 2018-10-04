/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.workout

import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.dvinc.workouttimer.presentation.ui.base.BaseMvpView
import com.dvinc.workouttimer.presentation.ui.base.MessageView

interface WorkoutView : BaseMvpView, MessageView {

    fun showWorkouts(workouts: List<WorkoutUi>)

    fun showDeleteWorkoutDialog(workout: WorkoutUi)

    fun showNewWorkoutDialog()
}
