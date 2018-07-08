/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.model.workout

import com.dvinc.circlestimer.R
import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.presentation.common.extension.toggleGone
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_workout.item_workout_name as workoutName
import kotlinx.android.synthetic.main.item_workout.item_workout_description as workoutDesc
import kotlinx.android.synthetic.main.item_workout.item_workout_total_exercises_count as exercisesCount
import kotlinx.android.synthetic.main.item_workout.item_workout_exercises_total_time as totalTime
import kotlinx.android.synthetic.main.item_workout.item_workout_active as activeLabel

class WorkoutItem constructor(
        private val workout: Workout
) : Item() {

    override fun getLayout() = R.layout.item_workout

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            workoutName.text = workout.name
            workoutDesc.text = workout.description
            exercisesCount.text = workout.exerciseCount.toString()
            totalTime.text = workout.exerciseTotalTime.toString()
            activeLabel.toggleGone(workout.isActive)
        }
    }
}
 