/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.model.exercise

data class Exercise(
        val id: Int = 0,
        val workoutId: Long,
        val name: String,
        val description: String,
        val time: Long,
        val type: ExerciseType
)
