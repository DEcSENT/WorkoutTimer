/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.model.exercise

import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import com.dvinc.workouttimer.R

enum class ExerciseTypeUi(@StringRes nameId: Int, @ColorRes color: Int) {

    PAUSE(R.string.exercise_type_pause, R.color.color_exercise_type_pause),

    WORK(R.string.exercise_type_work, R.color.color_exercise_type_work)
}
