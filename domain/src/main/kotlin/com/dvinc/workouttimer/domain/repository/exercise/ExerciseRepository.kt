/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.repository.exercise

import com.dvinc.workouttimer.domain.model.exercise.Exercise
import io.reactivex.Completable
import io.reactivex.Flowable

interface ExerciseRepository {

    fun obtainExercises(): Flowable<List<Exercise>>

    fun addExercise(exercise: Exercise): Completable

    fun addExercises(exercises: List<Exercise>): Completable
}
