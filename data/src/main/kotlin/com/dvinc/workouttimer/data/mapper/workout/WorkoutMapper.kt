/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.mapper.workout

import com.dvinc.workouttimer.data.database.entity.workout.WorkoutEntity
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutWithExecrisesWrapper
import com.dvinc.workouttimer.domain.model.workout.Workout

interface WorkoutMapper {

    fun fromEntity(wrappers: List<WorkoutWithExecrisesWrapper>): List<Workout>

    fun fromEntity(wrapper: WorkoutWithExecrisesWrapper): Workout

    fun fromDomain(workout: Workout): WorkoutEntity
}
