/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.exercise

import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseTypeEntity
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.model.exercise.ExerciseType
import javax.inject.Inject

class ExerciseDataMapper @Inject constructor() : ExerciseMapper {

    override fun fromEntityToDomain(entities: List<ExerciseEntity>): List<Exercise> {
        return entities.map { fromEntityToDomain(it) }
    }

    override fun fromEntityToDomain(entity: ExerciseEntity): Exercise {
        return with(entity) {
            Exercise(
                    id = uid,
                    workoutId = workoutId,
                    name = name,
                    description = description,
                    time = time,
                    type = fromEntity(type)
            )
        }
    }

    private fun fromEntity(type: ExerciseTypeEntity): ExerciseType {
        return when (type) {
            ExerciseTypeEntity.PAUSE -> ExerciseType.PAUSE
            ExerciseTypeEntity.WORK -> ExerciseType.WORK
        }
    }
}
