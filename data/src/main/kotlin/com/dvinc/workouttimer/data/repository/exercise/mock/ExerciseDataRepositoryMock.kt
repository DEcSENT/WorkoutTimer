/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.exercise.mock

import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.model.exercise.ExerciseType
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/* Mock repository. Replace it then database will be ready. */
class ExerciseDataRepositoryMock @Inject constructor() : ExerciseRepository {

    override fun obtainExercises(): Flowable<List<Exercise>> {
        val mock = ArrayList<Exercise>()
        (1..7).forEach {
            mock.add(Exercise(it, 10, "Exercise $it", "", 0L, ExerciseType.WORK))
        }
        return Flowable.fromArray(mock)
    }

    override fun addDefaultExercises(workoutId: Int): Single<Pair<Int, Long>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
