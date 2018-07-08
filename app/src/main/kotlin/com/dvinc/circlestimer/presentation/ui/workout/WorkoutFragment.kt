/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import android.os.Bundle
import android.view.View
import com.dvinc.circlestimer.R
import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.presentation.model.workout.WorkoutItem
import com.dvinc.circlestimer.ui.base.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_recycler as workoutRecycler

class WorkoutFragment : BaseFragment(), WorkoutView {

    companion object {
        const val TAG = "WorkoutFragment"
    }

    //TODO: Inject presenter
    lateinit var presenter: WorkoutPresenter

    override fun getFragmentLayoutId() = R.layout.fragment_workout

    private val workoutAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWorkoutsList()
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
        workoutAdapter.clear()
        workoutAdapter.addAll(workouts
                .map { WorkoutItem(it) })
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

    private fun initWorkoutsList() {
        workoutRecycler.adapter = workoutAdapter
    }

    private fun setupSwipeToDelete() {
        //TODO: setup swipe listener
    }

    private fun setupAddButton() {
        //TODO: click listener for add button
    }
}
