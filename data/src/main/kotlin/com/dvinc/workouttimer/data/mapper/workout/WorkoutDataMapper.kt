/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.workout

import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.model.workout.WorkoutEntity
import com.dvinc.workouttimer.domain.model.workout.Workout
import javax.inject.Inject

class WorkoutDataMapper @Inject constructor() : WorkoutMapper {

    override fun fromEntityToDomain(entity: WorkoutEntity, exercises: List<ExerciseEntity>): Workout {
        return with(entity) {
            Workout(
                    id = id,
                    name = name,
                    description = description,
                    exerciseCount = exercises.size,
                    exerciseTotalTime = getTotalTime(exercises),
                    isActive = isActive
            )
        }
    }

    private fun getTotalTime(exercises: List<ExerciseEntity>): Long {
        var totalTime = 0L
        (0 until exercises.size).forEach {
            totalTime += exercises[it].time
        }
        return totalTime
    }
}
