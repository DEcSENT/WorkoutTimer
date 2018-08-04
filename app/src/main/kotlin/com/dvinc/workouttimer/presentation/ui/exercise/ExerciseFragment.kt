/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import android.animation.Animator
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.common.adapter.divider.HorizontalDivider
import com.dvinc.workouttimer.presentation.common.application.WorkoutApp
import com.dvinc.workouttimer.presentation.common.extension.*
import com.dvinc.workouttimer.presentation.common.view.ADD_BUTTON_ANIMATION_DURATION
import com.dvinc.workouttimer.presentation.common.view.EXERCISE_ITEM_LEFT_PADDING
import com.dvinc.workouttimer.presentation.common.view.SimpleAnimationListener
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseItem
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseUi
import com.dvinc.workouttimer.presentation.ui.base.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_exercise.fragment_exercise_recycler as exercisesRecycler
import kotlinx.android.synthetic.main.fragment_exercise.fragment_exercise_add_button as exerciseAddButton
import javax.inject.Inject

class ExerciseFragment : BaseFragment(), ExerciseView {

    companion object {
        const val TAG = "ExerciseFragment"
    }

    @Inject
    lateinit var presenter: ExercisePresenter

    override fun getFragmentLayoutId() = R.layout.fragment_exercise

    private val exercisesAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectPresenter()
        initExercisesList()
        setupScrollListener()
        setupAddButtonClickListener()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.initView()
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun showExercises(exercises: List<ExerciseUi>) {
        exercisesAdapter.clear()
        exercisesAdapter.addAll(exercises.map { ExerciseItem(it) })
    }

    private fun injectPresenter() {
        context?.let {
            WorkoutApp.get(it).appComponent.inject(this)
        }
    }

    private fun initExercisesList() {
        exercisesRecycler.adapter = exercisesAdapter
        context?.let {
            exercisesRecycler.addItemDecoration(
                    HorizontalDivider(it, leftPadding = EXERCISE_ITEM_LEFT_PADDING.dp()))
        }
    }

    private fun setupScrollListener() {
        exercisesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0)
                    hideAddExerciseButton()
                else if (dy < 0){
                    showAddExerciseButton()
                }
            }
        })
    }

    private fun setupAddButtonClickListener() {
        exerciseAddButton.setOnClickListener {
            presenter.onAddExerciseButtonClick()
        }
    }

    private fun hideAddExerciseButton() {
        exerciseAddButton
                .animateFadeOutWithDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        exerciseAddButton.makeVisible()
                    }
                })
    }

    private fun showAddExerciseButton() {
        exerciseAddButton
                .animateFadeInWithDuration(ADD_BUTTON_ANIMATION_DURATION)
                .setListener(object : SimpleAnimationListener() {
                    override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                        exerciseAddButton.makeGone()
                    }
                })
    }
}
