/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.adapter.item.workout

import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.adapter.listener.workout.WorkoutItemButtonsClickListener
import com.dvinc.workouttimer.presentation.common.extension.toggleGone
import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_workout.item_workout_name as workoutName
import kotlinx.android.synthetic.main.item_workout.item_workout_description as workoutDesc
import kotlinx.android.synthetic.main.item_workout.item_workout_total_exercises_count as exercisesCount
import kotlinx.android.synthetic.main.item_workout.item_workout_exercises_total_time as totalTime
import kotlinx.android.synthetic.main.item_workout.item_workout_active as activeLabel
import kotlinx.android.synthetic.main.item_workout.item_workout_buttons_group as workoutControlButtonsGroup
import kotlinx.android.synthetic.main.item_workout.item_workout_delete_button as deleteWorkoutButton
import kotlinx.android.synthetic.main.item_workout.item_workout_activate_button as activateWorkoutButton

class WorkoutItem constructor(
        val workout: WorkoutUi,
        val buttonsClickListener: WorkoutItemButtonsClickListener,
        private var isExpanded: Boolean = false
) : Item() {

    override fun getLayout() = R.layout.item_workout

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            workoutName.text = workout.name
            workoutDesc.text = workout.description
            exercisesCount.text = workout.exerciseCount.toString()
            totalTime.text = workout.exerciseTotalTime
            activeLabel.toggleGone(workout.isActive)

            workoutControlButtonsGroup.toggleGone(isExpanded)

            itemView.setOnClickListener {
                isExpanded = !isExpanded
                notifyChanged()
            }

            deleteWorkoutButton.setOnClickListener {
                buttonsClickListener.onDeleteButtonClick(workout.id)
            }

            activateWorkoutButton.setOnClickListener {
                buttonsClickListener.onActivateButtonClick(workout.id)
            }
        }
    }
}
 