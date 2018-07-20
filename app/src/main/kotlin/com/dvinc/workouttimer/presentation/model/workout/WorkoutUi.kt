/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.model.workout

data class WorkoutUi(
        val id: Int,
        val name: String,
        val description: String,
        val exerciseCount: Int,
        val exerciseTotalTime: String,
        val isActive: Boolean
)
