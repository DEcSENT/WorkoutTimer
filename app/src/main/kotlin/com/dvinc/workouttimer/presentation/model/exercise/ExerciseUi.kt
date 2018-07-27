/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.model.exercise

data class ExerciseUi(
        val name: String,
        val description: String,
        val time: String,
        val exerciseType: ExerciseTypeUi)
