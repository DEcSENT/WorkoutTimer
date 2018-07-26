/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.exercise

import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.ui.base.BaseFragment
import javax.inject.Inject

class ExerciseFragment : BaseFragment(), ExerciseView {

    @Inject
    lateinit var presenter: ExercisePresenter

    override fun getFragmentLayoutId() = R.layout.fragment_exercise

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }
}
 