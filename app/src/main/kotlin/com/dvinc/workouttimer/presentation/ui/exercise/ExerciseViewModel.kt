/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import androidx.lifecycle.MutableLiveData
import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.usecase.exercise.ExerciseUseCase
import com.dvinc.workouttimer.domain.usecase.workout.WorkoutUseCase
import com.dvinc.workouttimer.presentation.mapper.exercises.ExercisePresentationMapper
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseUi
import com.dvinc.workouttimer.presentation.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ExerciseViewModel @Inject constructor(
        private val exercisesUseCase: ExerciseUseCase,
        private val workoutUseCase: WorkoutUseCase,
        private val exerciseMapper: ExercisePresentationMapper
) : BaseViewModel() {

    val exercisesData = MutableLiveData<List<ExerciseUi>>()

    val activeWorkoutData = MutableLiveData<Workout>()

    init {
        loadExercises()
        loadCurrentActiveWorkout()
    }

    private fun loadExercises() {
        addSubscription(
                exercisesUseCase.obtainExercisesForCurrentWorkout()
                        .map { exerciseMapper.mapDomainToUi(it) }
                        .subscribe(
                                { exercisesData.postValue(it) },
                                { Timber.e(it) }
                        )
        )
    }

    private fun loadCurrentActiveWorkout() {
        addSubscription(workoutUseCase.obtainActiveWorkout()
                .subscribe(
                        { activeWorkoutData.postValue(it) },
                        { Timber.e(it) }
                ))
    }
}
