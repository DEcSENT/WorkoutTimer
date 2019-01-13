/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.model.exercise

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.dvinc.workouttimer.R

enum class ExerciseTypeUi(
        @StringRes val nameId: Int,
        @ColorRes val colorId: Int
) {

    PAUSE(R.string.exercise_type_pause, R.color.color_exercise_type_pause),

    WORK(R.string.exercise_type_work, R.color.color_exercise_type_work)
}
