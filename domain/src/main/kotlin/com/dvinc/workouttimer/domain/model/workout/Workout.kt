/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.model.workout

data class Workout(
        val id: Int = 0,
        val name: String,
        val description: String,
        val exerciseCount: Int = 0,
        val exerciseTotalTime: Long = 0,
        val isActive: Boolean = false
)
