/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.model.exercise

import com.dvinc.workouttimer.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_exercise.item_exercise_name as name
import kotlinx.android.synthetic.main.item_exercise.item_exercise_type as type
import kotlinx.android.synthetic.main.item_exercise.item_exercise_icon as icon
import kotlinx.android.synthetic.main.item_exercise.item_exercise_time as time

class ExerciseItem(val exercise: ExerciseUi) : Item() {

    override fun getLayout() = R.layout.item_exercise

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            name.text = exercise.name
            time.text = exercise.time
            type.text = exercise.typeName
            icon.setBackgroundColor(exercise.typeColor)
        }
    }
}
 