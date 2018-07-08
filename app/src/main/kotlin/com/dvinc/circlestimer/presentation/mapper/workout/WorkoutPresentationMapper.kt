/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.mapper.workout

import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.presentation.model.workout.WorkoutUi
import java.text.SimpleDateFormat
import java.util.*

class WorkoutPresentationMapper {

    private val dateFormat = SimpleDateFormat("hh:mm:ss", Locale.getDefault())

    fun mapDomainToUi(list: List<Workout>): List<WorkoutUi> {
        return list.map { mapDomainToUi(it) }
    }

    fun mapDomainToUi(from: Workout): WorkoutUi {
        return with(from) {
            WorkoutUi(
                    id,
                    name,
                    description,
                    exerciseCount,
                    mapTimeToString(exerciseTotalTime),
                    isActive)
        }
    }

    private fun mapTimeToString(time: Long): String {
        return dateFormat.format(time)
    }
}
 