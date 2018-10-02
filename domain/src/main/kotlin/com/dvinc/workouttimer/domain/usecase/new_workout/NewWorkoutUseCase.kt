/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.usecase.new_workout

import com.dvinc.workouttimer.domain.common.execution.ThreadScheduler
import com.dvinc.workouttimer.domain.model.workout.Workout
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import io.reactivex.Completable
import javax.inject.Inject

class NewWorkoutUseCase @Inject constructor(
        private val workoutRepository: WorkoutRepository,
        private val exerciseRepository: ExerciseRepository,
        private val threadScheduler: ThreadScheduler
) {

    fun addNewWorkout(
            name: String,
            description: String,
            addDefaultExercise: Boolean
    ): Completable {
        //TODO: Think about default exercises logic
        val workout = Workout(
                name = name,
                description = description)
        return workoutRepository.addWorkout(workout)
                .compose(threadScheduler.ioToUiCompletable())
    }
}
