/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.workout

import android.animation.Animator
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.adapter.divider.HorizontalDivider
import com.dvinc.workouttimer.presentation.common.application.WorkoutApp
import com.dvinc.workouttimer.presentation.common.view.ADD_BUTTON_ANIMATION_DURATION
import com.dvinc.workouttimer.presentation.common.view.SimpleAnimationListener
import com.dvinc.workouttimer.presentation.common.adapter.item.workout.WorkoutItem
import com.dvinc.workouttimer.presentation.common.adapter.listener.workout.WorkoutItemButtonsClickListener
import com.dvinc.workouttimer.presentation.common.extension.*
import com.dvinc.workouttimer.presentation.common.viewmodel.ViewModelFactory
import com.dvinc.workouttimer.presentation.model.workout.WorkoutUi
import com.dvinc.workouttimer.presentation.ui.base.BaseFragment
import com.dvinc.workouttimer.presentation.ui.new_workout.NewWorkoutFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_recycler as workoutRecycler
import kotlinx.android.synthetic.main.fragment_workout.fragment_workout_add_button as addWorkoutButton

class WorkoutFragment : BaseFragment() {

    companion object {
        const val TAG = "WorkoutFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var workoutViewModel: WorkoutViewModel

    override fun getFragmentLayoutId() = R.layout.fragment_workout

    private val workoutAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectDependencies()
        initViewModel()
        initWorkoutsList()
        setupScrollListener()
        setupAddButtonCLickListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearDependencies()
    }

    private fun injectDependencies() {
        context?.let {
            WorkoutApp.get(it).getWorkoutComponent()?.inject(this)
        }
    }

    private fun clearDependencies() {
        context?.let {
            WorkoutApp.get(it).clearWorkoutComponent()
        }
    }

    private fun initViewModel() {
        workoutViewModel = obtainViewModel(viewModelFactory)
        observe(workoutViewModel.workoutsData, ::showWorkouts)
    }

    private fun showWorkouts(workouts: List<WorkoutUi>) {
        //TODO: Refactor this 2 lines?
        workoutAdapter.clear()
        workoutAdapter.addAll(workouts
                .map { workoutUi ->
                    WorkoutItem(workoutUi, object : WorkoutItemButtonsClickListener {
                        override fun onActivateButtonClick(workoutId: Int) {
                            workoutViewModel.onWorkoutActivated(workoutId)
                        }

                        override fun onDeleteButtonClick(workoutId: Int) {
                            workoutViewModel.onWorkoutDeleted(workoutId)
                        }

                        override fun onEditButtonClick(workoutId: Int) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }
                    })
                })
    }

    private fun showNewWorkoutDialog() {
        NewWorkoutFragment.newInstance().show(fragmentManager, NewWorkoutFragment.TAG)
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

    private fun setupScrollListener() {
        workoutRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
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
            showNewWorkoutDialog()
        }
    }

    private fun hideAddWorkoutButton() {
        addWorkoutButton
                .animateFadeOutWithDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        addWorkoutButton.makeGone()
                    }
                })
    }

    private fun showAddWorkoutButton() {
        addWorkoutButton
                .animateFadeInWithDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        addWorkoutButton.makeVisible()
                    }
                })
    }
}
