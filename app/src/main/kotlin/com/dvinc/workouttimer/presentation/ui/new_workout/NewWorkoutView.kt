/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.new_workout

import com.dvinc.workouttimer.presentation.ui.base.BaseMvpView

interface NewWorkoutView : BaseMvpView {

    fun closeScreen()

    fun toggleDefaultExerciseCheckBox()
}
