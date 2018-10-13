/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.model.exercise

import androidx.annotation.ColorInt

data class ExerciseUi(
        val id: Int,
        val name: String,
        val description: String,
        val time: String,
        val type: ExerciseTypeUi,
        val typeName: String,
        @ColorInt val typeColor: Int)
