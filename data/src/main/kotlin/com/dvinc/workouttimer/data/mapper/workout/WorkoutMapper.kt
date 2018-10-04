/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.workout

import com.dvinc.workouttimer.data.model.workout.WorkoutEntity
import com.dvinc.workouttimer.domain.model.workout.Workout

interface WorkoutMapper {

    fun fromEntity(entities: List<WorkoutEntity>): List<Workout>

    fun fromEntity(entity: WorkoutEntity): Workout

    fun fromDomain(workout: Workout): WorkoutEntity
}
