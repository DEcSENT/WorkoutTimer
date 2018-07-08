/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.workout

import android.animation.Animator
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.dvinc.circlestimer.App
import com.dvinc.circlestimer.R
import com.dvinc.circlestimer.domain.model.workout.Workout
import com.dvinc.circlestimer.presentation.common.extension.makeGone
import com.dvinc.circlestimer.presentation.common.extension.makeVisible
import com.dvinc.circlestimer.presentation.common.view.SimpleAnimationListener
import com.dvinc.circlestimer.presentation.model.workout.WorkoutItem
import com.dvinc.circlestimer.ui.base.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_recycler as workoutRecycler
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_add_button as addWorkoutButton

class WorkoutFragment : BaseFragment(), WorkoutView {

    companion object {
        const val TAG = "WorkoutFragment"
        private const val ADD_BUTTON_ANIMATION_DURATION = 200L
    }

    @Inject
    lateinit var presenter: WorkoutPresenter

    override fun getFragmentLayoutId() = R.layout.fragment_workout

    private val workoutAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectPresenter()
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

    private fun injectPresenter() {
        context?.let {
            App.get(it).appComponent.inject(this)
        }
    }

    private fun initWorkoutsList() {
        workoutRecycler.adapter = workoutAdapter
    }

    private fun setupSwipeToDelete() {
        //TODO: setup swipe listener
    }

    private fun setupAddButton() {
        //TODO: call new workout dialog from here

        workoutRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0)
                    hideAddWorkoutButton()
                else if (dy < 0){
                    showAddWorkoutButton()
                }
            }
        })
    }

    private fun hideAddWorkoutButton() {
        addWorkoutButton
                .animate()
                .alpha(0.0f)
                .setDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        addWorkoutButton.makeVisible()
                    }
                })
    }

    private fun showAddWorkoutButton() {
        addWorkoutButton
                .animate()
                .alpha(1.0f)
                .setDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                        addWorkoutButton.makeGone()
                    }
                })
    }
}
