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

    override fun fromEntity(entities: List<ExerciseEntity>): List<Exercise> {
        return entities.map { fromEntity(it) }
    }

    override fun fromEntity(entity: ExerciseEntity): Exercise {
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

    override fun fromDomain(exercises: List<Exercise>): List<ExerciseEntity> {
        return exercises.map {
            fromDomain(it)
        }
    }

    override fun fromDomain(exercise: Exercise): ExerciseEntity {
        return with(exercise) {
            ExerciseEntity(
                    workoutId = workoutId,
                    name = name,
                    description = description,
                    time = time,
                    type = fromDomain(type)
            )
        }
    }

    private fun fromEntity(type: ExerciseTypeEntity): ExerciseType {
        return when (type) {
            ExerciseTypeEntity.PAUSE -> ExerciseType.PAUSE
            ExerciseTypeEntity.WORK -> ExerciseType.WORK
        }
    }

    private fun fromDomain(type: ExerciseType): ExerciseTypeEntity {
        return when (type) {
            ExerciseType.PAUSE -> ExerciseTypeEntity.PAUSE
            ExerciseType.WORK -> ExerciseTypeEntity.WORK
        }
    }
}
