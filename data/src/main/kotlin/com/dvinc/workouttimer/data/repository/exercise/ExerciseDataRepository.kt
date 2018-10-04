/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.exercise

import com.dvinc.workouttimer.data.database.dao.ExerciseDao
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.model.exercise.ExerciseTypeEntity
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class ExerciseDataRepository @Inject constructor(
        private val exerciseDao: ExerciseDao,
        private val exerciseMapper: ExerciseMapper
) : ExerciseRepository {

    override fun obtainExercises(): Flowable<List<Exercise>> {
        return exerciseDao.getAllExercises()
                .map { exerciseMapper.fromEntityToDomain(it) }
    }

    override fun addDefaultExercises(workoutId: Int): Single<Pair<Int, Long>> {
        //TODO: Clean up here
        val simpleExercise = ExerciseEntity(
                workoutId = workoutId,
                name = "Test 1",
                description = "Hilarious exercise",
                time = 10000,
                type = ExerciseTypeEntity.WORK
        )

        return Completable.fromAction { exerciseDao.insert(simpleExercise) }
                .andThen(Single.just(Pair(1, 1000L)))
    }
}
