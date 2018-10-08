/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.adapter.listener.workout

interface WorkoutItemButtonsClickListener {

    fun onDeleteButtonClick(workoutId: Int)

    fun onActivateButtonClick(workoutId: Int)

    fun onEditButtonClick(workoutId: Int)
}
