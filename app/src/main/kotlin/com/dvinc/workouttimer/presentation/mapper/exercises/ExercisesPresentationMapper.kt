/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.mapper.exercises

import android.content.Context
import android.support.v4.content.ContextCompat
import com.dvinc.workouttimer.domain.model.exercise.Exercise
import com.dvinc.workouttimer.domain.model.exercise.ExerciseType
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseTypeUi
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseUi
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class ExercisesPresentationMapper @Inject constructor(
        private val context: Context
) {

    private val timeFormat = SimpleDateFormat("mm:ss", Locale.getDefault())

    fun mapDomainToUi(exercise: Exercise): ExerciseUi {
        return with(exercise) {
            ExerciseUi(
                    id,
                    name,
                    description,
                    mapTimeToString(time),
                    mapType(type),
                    mapTypeName(type),
                    mapTypeColor(type)
            )
        }
    }

    private fun mapTimeToString(time: Long): String {
        return timeFormat.format(time)
    }

    private fun mapType(type: ExerciseType): ExerciseTypeUi {
        return when (type) {
            ExerciseType.PAUSE -> ExerciseTypeUi.PAUSE
            ExerciseType.WORK -> ExerciseTypeUi.WORK
        }
    }

    private fun mapTypeName(type: ExerciseType): String {
        return when (type) {
            ExerciseType.PAUSE -> context.getString(ExerciseTypeUi.PAUSE.nameId)
            ExerciseType.WORK -> context.getString(ExerciseTypeUi.WORK.nameId)
        }
    }

    private fun mapTypeColor(type: ExerciseType): Int {
        return when (type) {
            ExerciseType.PAUSE -> ContextCompat.getColor(context, ExerciseTypeUi.PAUSE.colorId)
            ExerciseType.WORK -> ContextCompat.getColor(context, ExerciseTypeUi.WORK.colorId)
        }
    }
}
 