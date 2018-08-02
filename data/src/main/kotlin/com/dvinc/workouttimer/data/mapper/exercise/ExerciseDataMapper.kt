/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.exercise

import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.model.exercise.ExerciseType
import javax.inject.Inject

class ExerciseDataMapper @Inject constructor() : ExerciseMapper {

    override fun fromEntityToDomain(entities: List<ExerciseEntity>): List<Exercise> {
        return entities.map { fromEntityToDomain(it) }
    }

    //TODO: Method for type mapping
    override fun fromEntityToDomain(entity: ExerciseEntity): Exercise {
        return with(entity) {
            Exercise(
                    id = id,
                    workoutId = workoutId,
                    name = name,
                    description = description,
                    time = time,
                    type = ExerciseType.PAUSE
            )
        }
    }
}
