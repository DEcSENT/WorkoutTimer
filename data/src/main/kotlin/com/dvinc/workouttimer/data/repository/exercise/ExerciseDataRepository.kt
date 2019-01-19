/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.exercise

import com.dvinc.workouttimer.data.database.dao.ExerciseDao
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseTypeEntity
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
                .map { exerciseMapper.fromEntity(it) }
    }

    override fun addExercise(exercise: Exercise): Completable {
        return Single.fromCallable { exerciseMapper.fromDomain(exercise) }
                .flatMapCompletable { Completable.fromAction { exerciseDao.insert(it) } }
    }

    override fun addExercises(exercises: List<Exercise>): Completable {
        return Single.fromCallable { exerciseMapper.fromDomain(exercises) }
                .flatMapCompletable { Completable.fromAction { exerciseDao.insert(it) } }
    }
}
