/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.new_workout

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.application.WorkoutApp
import com.dvinc.workouttimer.presentation.common.extension.observe
import com.dvinc.workouttimer.presentation.common.extension.obtainViewModel
import com.dvinc.workouttimer.presentation.common.viewmodel.ViewModelFactory
import com.dvinc.workouttimer.presentation.ui.base.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_background as dialogBackground
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_cancel_button as cancelButton
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_add_button as addButton
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_name as nameEditText
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_description as descriptionEditText
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_default_exercise_checkbox as defaultExerciseCheckBox
import kotlinx.android.synthetic.main.dialog_new_workout.dialog_new_workout_default_exercise as defaultExerciseButton
import javax.inject.Inject

class NewWorkoutFragment : BaseDialogFragment() {

    companion object {

        const val TAG = "NewWorkoutDialog"

        fun newInstance() = NewWorkoutFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var newWorkoutViewModel: NewWorkoutViewModel

    override fun getFragmentLayoutId() = R.layout.dialog_new_workout

    override fun onStart() {
        super.onStart()
        with(dialog) {
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setupBackground()
        setupCancelButton()
        setupAddWorkoutButton()
        setupDefaultExerciseButton()
    }

    override fun injectDependencies() {
        context?.let {
            WorkoutApp.get(it).getNewWorkoutComponent()?.inject(this)
        }
    }

    override fun clearDependencies() {
        context?.let {
            WorkoutApp.get(it).clearNewWorkoutComponent()
        }
    }

    override fun initViewModel() {
        newWorkoutViewModel = obtainViewModel(viewModelFactory)
        observe(newWorkoutViewModel.dialogVisibilityData, ::showDialog)
    }

    private fun showDialog(isVisible: Boolean) {
        if (!isVisible) {
            dismiss()
        }
    }

    private fun toggleDefaultExerciseCheckBox() {
        defaultExerciseCheckBox.toggle()
    }

    private fun setupBackground() {
        dialogBackground.setOnClickListener {
            dismiss()
        }
    }

    private fun setupCancelButton() {
        cancelButton.setOnClickListener {
            dismiss()
        }
    }

    private fun setupAddWorkoutButton() {
        addButton.setOnClickListener {
            val workoutName = nameEditText.text.toString()
            val workoutDescription = descriptionEditText.text.toString()
            val addDefaultExercise = defaultExerciseCheckBox.isChecked
            newWorkoutViewModel.onNewWorkoutAdded(workoutName, workoutDescription, addDefaultExercise)
        }
    }

    private fun setupDefaultExerciseButton() {
        defaultExerciseButton.setOnClickListener {
            toggleDefaultExerciseCheckBox()
        }
    }
}
