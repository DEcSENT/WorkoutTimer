/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.model.workout

import com.dvinc.circlestimer.R
import com.dvinc.circlestimer.domain.model.workout.Workout
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_workout.item_workout_name as workoutName

class WorkoutItem constructor(
        private val workout: Workout
) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            workoutName.text = workout.name

        }

    }

    override fun getLayout() = R.layout.item_workout

}
 