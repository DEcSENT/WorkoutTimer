/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.workout

import androidx.lifecycle.MutableLiveData
import com.dvinc.workouttimer.domain.usecase.workout.WorkoutUseCase
import com.dvinc.workouttimer.presentation.mapper.workout.WorkoutPresentationMapper
import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.dvinc.workouttimer.presentation.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class WorkoutViewModel @Inject constructor(
        private val workoutUseCase: WorkoutUseCase,
        private val mapper: WorkoutPresentationMapper
) : BaseViewModel() {

    val workoutsData = MutableLiveData<List<WorkoutUi>>()

    init {
        loadWorkouts()
    }

    fun onWorkoutDeleted(workoutId: Int) {
        addSubscription(workoutUseCase.deleteWorkoutById(workoutId)
                .subscribe(
                        { /* TODO: Show message here */ },
                        { Timber.e(it) }
                ))
    }

    fun onWorkoutActivated(workoutId: Int) {
        addSubscription(workoutUseCase.selectActiveWorkout(workoutId)
                .subscribe(
                        { /* TODO: Show message here */ },
                        { Timber.e(it) }))
    }

    private fun loadWorkouts() {
        addSubscription(workoutUseCase.obtainWorkouts()
                .map { mapper.mapDomainToUi(it) }
                .subscribe(
                        { workoutsData.postValue(it) },
                        { Timber.e(it) }
                ))
    }
}
