/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import android.os.Bundle
import android.view.View
import com.dvinc.circlestimer.R
import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.presentation.model.workout.WorkoutUi
import com.dvinc.circlestimer.ui.base.BaseFragment

class WorkoutFragment : BaseFragment(), WorkoutView {

    companion object {
        const val TAG = "WorkoutFragment"
    }

    //TODO: Inject presenter
    lateinit var presenter: WorkoutPresenter

    override fun getFragmentLayoutId() = R.layout.fragment_workout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupWorkoutsList()
        setupSwipeToDelete()
        setupAddButton()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun showWorkouts(workouts: List<Workout>) {
        //TODO: handle new list
    }

    override fun showDeleteWorkoutDialog(workout: Workout) {
        //TODO: show delete dialog
    }

    override fun showNewWorkoutDialog() {
        //TODO: show workout dialog
    }

    override fun showMessage(message: String) {
        //TODO: show message
    }

    override fun showError(error: String) {
        //TODO: show error
    }

    private fun setupWorkoutsList() {
        //TODO: recycler and adapter with listener, etc.
    }

    private fun setupSwipeToDelete() {
        //TODO: setup swipe listener
    }

    private fun setupAddButton() {
        //TODO: click listener for add button
    }
}
