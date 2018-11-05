/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.new_workout

import androidx.lifecycle.MutableLiveData
import com.dvinc.workouttimer.domain.usecase.new_workout.NewWorkoutUseCase
import com.dvinc.workouttimer.presentation.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class NewWorkoutViewModel @Inject constructor(
        private val newWorkoutUseCase: NewWorkoutUseCase
) : BaseViewModel() {

    /*
     * Experimental flow for controlling dialog visibility.
     */
    val dialogVisibilityData = MutableLiveData<Boolean>()

    fun onNewWorkoutAdded(name: String, description: String, addDefaultExercises: Boolean) {
        addSubscription(
                newWorkoutUseCase.addNewWorkout(name, description, addDefaultExercises)
                        .subscribe(
                                { dialogVisibilityData.postValue(false) },
                                { Timber.e(it) }
                        )
        )
    }
}
