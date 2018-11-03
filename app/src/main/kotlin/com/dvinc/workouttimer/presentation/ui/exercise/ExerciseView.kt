/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseUi
import com.dvinc.workouttimer.presentation.ui.base.BaseMvpView

interface ExerciseView : BaseMvpView {

    fun showExercises(exercises: List<ExerciseUi>)

    fun showActiveWorkoutInfo(workout: Workout)

    fun showNewExerciseDialog()
}
