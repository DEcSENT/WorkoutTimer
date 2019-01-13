/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.exercise

import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity
import com.dvinc.workouttimer.domain.model.exercise.Exercise

interface ExerciseMapper {

    fun fromEntityToDomain(entities: List<ExerciseEntity>): List<Exercise>

    fun fromEntityToDomain(entity: ExerciseEntity): Exercise
}
