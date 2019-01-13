/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.workout

import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutEntity
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutWithExercisesWrapper
import com.dvinc.workouttimer.domain.model.workout.Workout
import javax.inject.Inject

class WorkoutDataMapper @Inject constructor() : WorkoutMapper {

    override fun fromEntity(wrappers: List<WorkoutWithExercisesWrapper>): List<Workout> {
        return wrappers.map {
            fromEntity(it)
        }
    }

    override fun fromEntity(wrapper: WorkoutWithExercisesWrapper): Workout {
        return with(wrapper) {
            Workout(
                    id = requireNotNull(workout).uid,
                    name = requireNotNull(workout).name,
                    description = requireNotNull(workout).description,
                    isActive = requireNotNull(workout).isActive,
                    exerciseCount = requireNotNull(exercises).size,
                    exerciseTotalTime = calculateTotalExerciseTime(requireNotNull(exercises))
            )
        }
    }

    override fun fromDomain(workout: Workout): WorkoutEntity {
        return with(workout) {
            WorkoutEntity(
                    name = name,
                    description = description,
                    isActive = isActive
            )
        }
    }

    private fun calculateTotalExerciseTime(exercises: List<ExerciseEntity>): Long {
        var totalTime = 0L
        exercises.forEach {
            totalTime += it.time
        }
        return totalTime
    }
}
