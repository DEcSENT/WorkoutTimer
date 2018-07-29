/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import android.os.Bundle
import android.view.View
import com.dvinc.workouttimer.App
import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseItem
import com.dvinc.workouttimer.presentation.model.exercise.ExerciseUi
import com.dvinc.workouttimer.presentation.ui.base.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_exercise.fragment_exercise_recycler as exercisesRecycler
import javax.inject.Inject

class ExerciseFragment : BaseFragment(), ExerciseView {

    @Inject
    lateinit var presenter: ExercisePresenter

    override fun getFragmentLayoutId() = R.layout.fragment_exercise

    private val exercisesAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectPresenter()
        initExercisesList()
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
            App.get(it).appComponent.inject(this)
        }
    }

    private fun initExercisesList() {
        exercisesRecycler.adapter = exercisesAdapter
    }
}
 