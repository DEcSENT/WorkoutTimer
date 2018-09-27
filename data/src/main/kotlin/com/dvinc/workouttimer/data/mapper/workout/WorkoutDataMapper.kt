/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.workout

import com.dvinc.workouttimer.data.model.workout.WorkoutEntity
import com.dvinc.workouttimer.domain.model.workout.Workout
import javax.inject.Inject

class WorkoutDataMapper @Inject constructor() : WorkoutMapper {

    override fun fromEntity(entities: List<WorkoutEntity>): List<Workout> {
        return entities.map { fromEntity(it) }
    }

    override fun fromEntity(entity: WorkoutEntity): Workout {
        return with(entity) {
            Workout(
                    id = uid,
                    name = name,
                    description = description,
                    exerciseCount = exerciseCount,
                    exerciseTotalTime = totalTime,
                    isActive = isActive
            )
        }
    }

    override fun fromDomain(workout: Workout): WorkoutEntity {
        return with(workout) {
            WorkoutEntity(
                    name = name,
                    description = description,
                    exerciseCount = exerciseCount,
                    totalTime = exerciseTotalTime,
                    isActive = isActive
            )
        }
    }
}
