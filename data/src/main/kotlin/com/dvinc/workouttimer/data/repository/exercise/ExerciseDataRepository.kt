/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repository.exercise

import com.dvinc.workouttimer.data.database.dao.ExerciseDao
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import io.reactivex.Flowable
import javax.inject.Inject

class ExerciseDataRepository @Inject constructor(
        private val exerciseDao: ExerciseDao,
        private val exerciseMapper: ExerciseMapper
) : ExerciseRepository {

    override fun obtainExercises(): Flowable<List<Exercise>> {
        return exerciseDao.getAllExercises()
                .map { exerciseMapper.fromEntityToDomain(it) }
    }
}
