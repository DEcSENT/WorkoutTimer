/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.workout

import android.animation.Animator
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.adapter.divider.HorizontalDivider
import com.dvinc.workouttimer.presentation.common.application.WorkoutApp
import com.dvinc.workouttimer.presentation.common.view.ADD_BUTTON_ANIMATION_DURATION
import com.dvinc.workouttimer.presentation.common.view.SimpleAnimationListener
import com.dvinc.workouttimer.presentation.common.adapter.item.workout.WorkoutItem
import com.dvinc.workouttimer.presentation.common.extension.*
import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.dvinc.workouttimer.presentation.ui.base.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_recycler as workoutRecycler
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_add_button as addWorkoutButton

class WorkoutFragment : BaseFragment(), WorkoutView {

    companion object {
        const val TAG = "WorkoutFragment"
    }

    @Inject
    lateinit var presenter: WorkoutPresenter

    override fun getFragmentLayoutId() = R.layout.fragment_workout

    private val workoutAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectPresenter()
        initWorkoutsList()
        setupAdapterItemClickListener()
        setupScrollListener()
        setupAddButtonCLickListener()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearDependencies()
    }

    override fun showWorkouts(workouts: List<WorkoutUi>) {
        //TODO: Refactor this 2 lines?
        workoutAdapter.clear()
        workoutAdapter.addAll(workouts
                .map { WorkoutItem(it) })
    }

    override fun showDeleteWorkoutDialog(workout: WorkoutUi) {
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
            WorkoutApp.get(it).getWorkoutComponent()?.inject(this)
        }
    }

    private fun clearDependencies() {
        context?.let {
            WorkoutApp.get(it).clearWorkoutComponent()
        }
    }

    private fun initWorkoutsList() {
        workoutRecycler.adapter = workoutAdapter
        context?.let {
            workoutRecycler.addItemDecoration(HorizontalDivider(
                    context = it,
                    leftPadding = 0.dp(),
                    rightPadding = 0.dp()
            ))
        }
    }

    private fun setupAdapterItemClickListener() {
        workoutAdapter.setOnItemClickListener { item, _ ->
            if (item is WorkoutItem) {
                presenter.onWorkoutClick(item.workout)
            }
        }
    }

    private fun setupScrollListener() {
        workoutRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0)
                    hideAddWorkoutButton()
                else if (dy < 0) {
                    showAddWorkoutButton()
                }
            }
        })
    }

    private fun setupAddButtonCLickListener() {
        addWorkoutButton.setOnClickListener {
            presenter.onAddButtonClick()
        }
    }

    private fun hideAddWorkoutButton() {
        addWorkoutButton
                .animateFadeOutWithDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        addWorkoutButton.makeVisible()
                    }
                })
    }

    private fun showAddWorkoutButton() {
        addWorkoutButton
                .animateFadeInWithDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                        addWorkoutButton.makeGone()
                    }
                })
    }
}
