/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.exercise

import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity
import com.dvinc.workouttimer.domain.model.exercise.Exercise

interface ExerciseMapper {

    fun fromEntity(entities: List<ExerciseEntity>): List<Exercise>

    fun fromEntity(entity: ExerciseEntity): Exercise

    fun fromDomain(exercises: List<Exercise>): List<ExerciseEntity>

    fun fromDomain(exercise: Exercise): ExerciseEntity
}
