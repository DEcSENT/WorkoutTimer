/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.model.exercise

data class Exercise(
        val id: Int,
        val name: String,
        val description: String,
        val time: Long,
        val type: ExerciseType
)