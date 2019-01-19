/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.usecase.new_workout

import com.dvinc.workouttimer.domain.common.execution.ThreadScheduler
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.model.exercise.ExerciseType
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

    companion object {

        private const val DEFAULT_EXERCISE_NAME = "Default exercise"

        private const val DEFAULT_EXERCISE_DESC = "Default exercise description"

        private const val DEFAULT_EXERCISE_TIME = 10000L

    }

    fun addNewWorkout(
            name: String,
            description: String,
            addDefaultExercise: Boolean
    ): Completable {
        val workout = Workout(
                name = name,
                description = description
        )
        return workoutRepository.addWorkout(workout)
                .flatMapCompletable { insertedWorkoutId ->
                    if (addDefaultExercise) {
                        val defaultExercise = createDefaultExercise(insertedWorkoutId)
                        exerciseRepository.addExercise(defaultExercise)
                    } else {
                        Completable.complete()
                    }
                }
                .compose(threadScheduler.ioToUiCompletable())
    }

    private fun createDefaultExercise(workoutId: Long): Exercise {
        return Exercise(
                workoutId = workoutId,
                name = DEFAULT_EXERCISE_NAME,
                description = DEFAULT_EXERCISE_DESC,
                time = DEFAULT_EXERCISE_TIME,
                type = ExerciseType.WORK
        )
    }
}
