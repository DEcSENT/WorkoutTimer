/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import com.dvinc.workouttimer.domain.usecase.exercise.ExerciseUseCase
import com.dvinc.workouttimer.domain.usecase.workout.WorkoutUseCase
import com.dvinc.workouttimer.presentation.mapper.exercises.ExercisePresentationMapper
import com.dvinc.workouttimer.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class ExerciseViewModel @Inject constructor(
        private val exercisesUseCase: ExerciseUseCase,
        private val workoutUseCase: WorkoutUseCase,
        private val exerciseMapper: ExercisePresentationMapper
) : BaseViewModel() {

    //TODO: Copy methods from presenter
}
