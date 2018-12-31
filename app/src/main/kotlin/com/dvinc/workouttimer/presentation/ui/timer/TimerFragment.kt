/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.timer

import com.dvinc.workouttimer.R
import com.dvinc.workouttimer.presentation.ui.base.BaseFragment

/*
 * This fragment is empty, for now.
 */
class TimerFragment : BaseFragment() {

    companion object {
        const val TAG = "TimerFragment"
    }

    override fun getFragmentLayoutId() = R.layout.fragment_timer

    override fun injectDependencies() {
    }

    override fun clearDependencies() {
    }

    override fun initViewModel() {
    }
}
