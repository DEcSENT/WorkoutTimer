/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.workout

import com.dvinc.workouttimer.data.model.workout.WorkoutEntity
import com.dvinc.workouttimer.domain.model.workout.Workout
import javax.inject.Inject

class WorkoutDataMapper @Inject constructor() : WorkoutMapper {

    override fun fromEntityToDomain(entities: List<WorkoutEntity>): List<Workout> {
        return entities.map {
            with(it) {
                Workout(
                        id = id,
                        name = name,
                        description = description,
                        exerciseCount = exerciseCount,
                        exerciseTotalTime = totalTime,
                        isActive = isActive
                )
            }
        }
    }
}
