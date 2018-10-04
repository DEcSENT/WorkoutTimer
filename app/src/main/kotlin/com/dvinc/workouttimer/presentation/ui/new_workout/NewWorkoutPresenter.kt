/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.new_workout

import com.dvinc.workouttimer.domain.usecase.new_workout.NewWorkoutUseCase
import com.dvinc.workouttimer.presentation.ui.base.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class NewWorkoutPresenter @Inject constructor(
        private val newWorkoutUseCase: NewWorkoutUseCase
) : BasePresenter<NewWorkoutView>() {

    fun onNewWorkoutAdded(name: String, description: String, addDefaultExercises: Boolean) {
        addSubscription(
                newWorkoutUseCase.addNewWorkout(name, description, addDefaultExercises)
                        .subscribe(
                                { getView()?.closeScreen() },
                                { Timber.e(it) }
                        )
        )
    }

    fun onDefaultExerciseButtonClicked() {
        getView()?.toggleDefaultExerciseCheckBox()
    }
}
